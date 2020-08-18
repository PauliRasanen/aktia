package com.aktia.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aktia.aktia3.AktiaDao;
import com.aktia.supportingclasses.JMS2;


@WebServlet("/ChangeTaskStatus")
public class ChangeTaskStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangeTaskStatus() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	//Vaihtaa tehtävän statuksen ja ohjaa osoitteeseen /ListDb
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/ListDb";
		String taskId = request.getParameter("taskId");
		String taskDone = request.getParameter("taskDone");
		System.out.println("Servlet infot: " + taskId + " " + taskDone);
		AktiaDao.changeTaskStatus(taskId, taskDone);
		try {
			JMS2.messageQueue("POST: ChangeTaskStatus - taskId:" + taskId + " taskDone:" + taskDone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
