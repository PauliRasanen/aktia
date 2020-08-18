package com.aktia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aktia.aktia3.AktiaDao;
import com.aktia.supportingclasses.JMS2;
import com.aktia.supportingclasses.RandomString;

//Lisää tehtävän käyttäjälle ja ohjaa osoitteeseen /ListDb
@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddTask() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/ListDb";
		RandomString rs = new RandomString();
		String taskId = rs.randomString(16);
		String customerId = request.getParameter("customerId");
		String taskDescription = request.getParameter("taskDescription");
		String taskDone = request.getParameter("taskDone");
		AktiaDao.addCustomerTask(taskId, customerId, taskDescription, taskDone);
		try {
			JMS2.messageQueue("POST: AddTask - taskId:" + taskId + " customerId:" + customerId + " taskDescription:" + taskDescription + " taskDone:" + taskDone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}

}
