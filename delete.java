package chazhao;
import
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
			{
		doPost(request,response);
	}
	
	
	url = "delete.jsp";
		  response.setContentType("text/html");
		
		  response.setCharacterEncoding("UTF-8");
		
		  String title=request.getParameter("title");
		
		if(database.deleteInfo(title))
		{
			request.setAttribute("message","书名为"+title+"删除成功！O(∩_∩)O");	
		}
		else
		{
			request.setAttribute("message", "删除失败！~~(>_<)~~ ");
		}
		RequestDispatcher rd=request.getRequestDispatcher(url);
		
		rd.forward(request, response);
		return;
	}
	
}