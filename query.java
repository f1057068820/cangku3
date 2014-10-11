package chazhao;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import biao.author;

public class query extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public void destroy() {
		super.destroy(); 
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "queryshow.jsp";
		
		 response.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html");
		List list=new ArrayList();
		author bookname = new author();
		String name = request.getParameter("name").trim();
		bookname=database.QueryName(name);
		
		String authorid = bookname.getAuthorid();
		list = database.QueryBooks(authorid);
		request.setAttribute("list", list);
		
	    RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}
	

}
