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
			request.setAttribute("message","����Ϊ"+title+"ɾ���ɹ���O(��_��)O");	
		}
		else
		{
			request.setAttribute("message", "ɾ��ʧ�ܣ�~~(>_<)~~ ");
		}
		RequestDispatcher rd=request.getRequestDispatcher(url);
		
		rd.forward(request, response);
		return;
	}
	
}