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

//Lisää käyttäjän ja ohjaa osoitteeseen /CustomerAdded.jsp
@WebServlet("/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddCustomer() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String url = "/CustomerAdded.jsp";
    	RandomString rs = new RandomString();
		String customerId = rs.randomString(16);
		String customerName = request.getParameter("customerName");
		AktiaDao.addCustomer(customerId, customerName);
		try {
			JMS2.messageQueue("POST: AddCustomer - customerId:" + customerId + " customerName:" + customerName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("customerId", customerId);
		request.setAttribute("customerName", customerName);
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}

}
