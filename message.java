package chazhao;
import java.io.IOException;
import javax.servlet.http.HttpServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import biao.book;
public class message extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		doPost(request,response);
	}
	public void destroy() 
	{
		
		super.destroy(); 		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{
		book book = new book();
		String url="showbook.jsp";
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		if(title!=null)
		{
			book=database.QueryInfo(title);
			if(book.getTitle()!=null)
			{
				request.setAttribute("isbn", book.getIsbn());
				request.setAttribute("title", book.getTitle());
				
				request.setAttribute("authorid", book.getAuthorid());
				
				request.setAttribute("publisher", book.getPublisher());
				
				request.setAttribute("publishdate", book.getPublishdate());
				request.setAttribute("price", book.getPrice());
			}
		}		
	    RequestDispatcher rd=request.getRequestDispatcher(url);
		rd.forward(request, response);
		return;
	}

}

