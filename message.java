package chazhao;
import java.io.IOException;
import doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
			{6666
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

