package com.aktia.aktia3;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.aktia.models.Customer;
import com.aktia.models.Customertask;
import com.aktia.supportingclasses.RandomString;


public class AktiaDao 
{
	
	private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("aktia3"); 
    
	//Lisää serverin käynnistyksen jälkeen kantaan valmista dataa
    public static void addStart() {
    	clearDb();
    	RandomString rs = new RandomString();
		String randStr = rs.randomString(16);
		String taskRndStr = rs.randomString(16);
		addCustomer(randStr, "Pauli");
		addCustomerTask(taskRndStr, randStr, "Paulille eka tehtävä", "true");
		taskRndStr = rs.randomString(16);
		addCustomerTask(taskRndStr, randStr, "Paulille toka tehtävä", "true");
		randStr = rs.randomString(16);
		taskRndStr = rs.randomString(16);
		addCustomer(randStr, "Janne");
		addCustomerTask(taskRndStr, randStr, "Jannelle eka tehtävä", "true");
		randStr = rs.randomString(16);
		addCustomer(randStr, "Tero");
		randStr = rs.randomString(16);
		addCustomer(randStr, "Jari");
		randStr = rs.randomString(16);
		addCustomer(randStr, "Tiiu");
    }
    	
    //Lisää käyttäjän syöteellä String customerId, String customerName 
    public static void addCustomer(String customerId, String customerName) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	EntityTransaction et = null;
    	try {
    		et = em.getTransaction();
    		et.begin();
    		Customer c = new Customer(customerId, customerName);
    		em.persist(c);
    		et.commit();
    	}
    	catch (Exception ex) {
			if(et != null) {
				et.rollback();
			}ex.printStackTrace();
		}
    	finally {
    		em.close();
    	}
    }
    
    //Lisää käyttäjän tehtävän syötteellä String customerId, String taskDescription, String taskDone
    public static void addCustomerTask(String taskId, String customerId, String taskDescription, String taskDone) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	EntityTransaction et = null;
    	try {
    		et = em.getTransaction();
    		et.begin();
    		Customertask c = new Customertask(customerId, taskDescription, taskDone, taskId);
    		em.persist(c);
    		et.commit();
    	}
    	catch (Exception ex) {
			if(et != null) {
				et.rollback();
			}ex.printStackTrace();
		}
    	finally {
    		em.close();
    	}
    }
    
    //Hakee kannan tauluista customer ja customertask  listan jossa on käyttäjät sekä mahdolliset käyttäjällä olevat taskit
    public static List<Object[]> getCustomersAndTasks() {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	String query = "SELECT DISTINCT c.customerId, c.customerName, ct.taskId, ct.taskDescription, ct.taskDone FROM Customer c LEFT OUTER JOIN Customertask ct on c.customerId = ct.customerId";
    	Query tq = em.createQuery(query);
    	List<Object[]> custTasks = null;
    	try {
    		custTasks = tq.getResultList();    
    		
    	}
    	catch(NoResultException ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
		return custTasks;
    }
    
    //Päivittää tehtävän statuksen
    public static void changeTaskStatus(String taskId, String taskDone) {
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	EntityTransaction et = null;

    	try {
    		et = em.getTransaction();
    		et.begin();
        	Query tq = em.createQuery("UPDATE Customertask ct SET ct.taskDone = :taskDone WHERE ct.taskId = :taskId");
        	tq.setParameter("taskDone", taskDone);
        	tq.setParameter("taskId", taskId);
        	tq.executeUpdate();
        	et.commit();
    	}
    	catch (Exception ex) {
			if(et != null) {
				et.rollback();
			}ex.printStackTrace();
		}
    	finally {
    		em.close();
    	}
    }
    
    //Tyhjentää kannasta customer ja customertask taulut
    public static void clearDb(){
    	EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
    	Query delete1 = em.createQuery("DELETE FROM Customer");
    	Query delete2 = em.createQuery("DELETE FROM Customertask");    	
    	try {
        	em.getTransaction().begin();
        	delete1.executeUpdate();
        	delete2.executeUpdate();
        	em.getTransaction().commit();    		
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	finally {
    		em.close();
    	}
    }
    
}
