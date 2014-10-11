package chazhao;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import dbopen.connectiondb;
import biao.book;
import biao.author;

public class database {
	 private static Connection con; 
	 private static PreparedStatement stmt;
	
	 public static boolean addInfo(book book)
	{
		
	    boolean flag=false;
	    try{
	    	con=connectiondb.getConnection();
			stmt=con.prepareStatement("insert into book "+"values(?,?,?,?,?,?)");
			stmt.setString(1,book.getIsbn());
			stmt.setString(2,book.getTitle());
			
			stmt.setString(3,book.getAuthorid());
			
			stmt.setString(4,book.getPublishdate());
			stmt.setString(5,book.getPrice());
			
			stmt.setString(6,book.getPublisher());
            if(stmt.executeUpdate()==1)flag=true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		connectiondb.Close(con, stmt);
		return flag;
    }
	
	public static book QueryInfo(String title)
	{
		book book = new book();
	    ResultSet rs=null;
	    try{
			con=connectiondb.getConnection();
			stmt=con.prepareStatement("select * from book where title= '"+title+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				book.setIsbn(rs.getString("isbn"));
				
				book.setTitle(rs.getString("title"));
				book.setAuthorid(rs.getString("authorid"));
				
				book.setPublishdate(rs.getString("publishdate"));
				book.setPrice(rs.getString("price"));
				
				book.setPublisher(rs.getString("publisher"));
			}
		}catch(SQLException e)
		{
			book=null;
		}if(rs!=null){
			try{
    			rs.close();
    			}
			catch(SQLException e){}
		}
		connectiondb.Close(con, stmt);
		return book;
	}

	public static List QueryBooks(String authorid)
	{
		List list=new ArrayList();
	    ResultSet rs=null;
	    try{
			con=connectiondb.getConnection();
			stmt=con.prepareStatement("select * from book where authorid= '"+authorid+"'");
			rs=stmt.executeQuery();
			while(rs.next()){
				book book = new book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				
				book.setAuthorid(rs.getString("authorid"));
				
				
				book.setPublishdate(rs.getString("publishdate"));
				book.setPrice(rs.getString("price"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
		}
	    catch(SQLException e)
		{
			list=null;
		}if(rs!=null)
		{
			try
			{
    			rs.close();
    			}
			catch(SQLException e){}
		}
		connectiondb.Close(con, stmt);
		return list;
	}
	public static boolean deleteInfo(String title)
	{
		boolean flag=false;
		try
		{
	    	con=connectiondb.getConnection();
			stmt=con.prepareStatement("delete from book where title ='"+title+"'");
            if(stmt.executeUpdate()==1)flag=true;
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		connectiondb.Close(con, stmt);
		return flag;
	}
	public static author QueryName(String name)
	{
		author bookname = new author();
	    ResultSet rs=null;
	    try{
			con=connectiondb.getConnection();
			stmt=con.prepareStatement("select * from author where name= '"+name+"'");
			rs=stmt.executeQuery();
			while(rs.next()){				
				
				bookname.setAuthorid(rs.getString("authorid"));
				bookname.setAge(rs.getString("age"));
				
				bookname.setCountry(rs.getString("country"));
				bookname.setName(rs.getString("name"));
			}
		}catch(SQLException e)
		{
			bookname=null;
		}if(rs!=null){
			try
			{
    			rs.close();
    			}
			catch(SQLException e){}
		}
		connectiondb.Close(con, stmt);
		return bookname;
	}

}