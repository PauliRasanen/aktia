package com.aktia.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aktia.aktia3.AktiaDao;
import com.aktia.supportingclasses.JMS2;

import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.List;


@WebServlet("/ListDb")
public class ListDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ListDb() {
        super();
        
    }

    //Hakee ja listaa käyttäjät ja heidän tehtävänsä
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		
		try {
			List<Object[]> custTasks = AktiaDao.getCustomersAndTasks();

            out.println("<table border=1 width=40% height=20%>");  
			out.println("<tr><th>customerId</th><th>customerName</th><th>taskId</th><th>taskDescription</th><th>done</th><tr>");
			for (Object[] custTask : custTasks) {
    			out.println("<tr><td>" + custTask[0] + "</td><td>" + custTask[1] + "</td><td>" + custTask[2] + "</td><td>" + custTask[3] + "</td><td>" + custTask[4] + "</td></tr>");
    		}
			out.println("</table>");
			JMS2.messageQueue("GET: ListDb");
		} catch (URISyntaxException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
		finally {
			out.close();
		}
	}
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}


}
