package chazhao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class delete extends HttpServlet
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
		  String url = "delete.jsp";
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