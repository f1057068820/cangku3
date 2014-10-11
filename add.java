//genggai
//kengkengkengkeng
package chazhao;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import biao.book;
public class add extends HttpServlet {
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
		book book = new book();
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		book.setIsbn(request.getParameter("isbn").trim());
		 book.setTitle(request.getParameter("title").trim());
		 book.setAuthorid(request.getParameter("authorid").trim());
		book.setPublisher(request.getParameter("publisher").trim());
		
		book.setPublishdate(request.getParameter("publishdate").trim());
		book.setPrice(request.getParameter("price").trim());
		if(database.addInfo(book))
		{
			 request.setAttribute("message", "书名为"+book.getTitle()+"添加成功！");
		}
		RequestDispatcher rd=request.getRequestDispatcher(url);
		 rd.forward(request, response);
	}
	
}