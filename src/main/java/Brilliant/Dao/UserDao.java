package Brilliant.Dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Brilliant.bean.User;

public class UserDao {
	public static Connection getcon()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3309/jspcrud","root","root");
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static int save(User u)
	{
		int status=0;
		try
		{
			Connection con=getcon();
			PreparedStatement ps=con.prepareStatement("INSERT INTO register(name,password,email,gender,country) VALUES (?,?,?,?,?)");
			ps.setString(1,u.getName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getGender());
			ps.setString(5,u.getCountry());
			status=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int update(User u) 
	{
		int status=0;
		try
		{
			Connection con=getcon();
			PreparedStatement ps=con.prepareStatement("UPDATE register SET name=?, password=?,email=?,gender=?,country=? where id=?");
			ps.setString(1,u.getName());
			ps.setString(2,u.getPassword());
			ps.setString(3,u.getEmail());
			ps.setString(4,u.getGender());
			ps.setString(5,u.getCountry());
			ps.setInt(6, u.getId());
			status=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static int delete(User u) 
	{
		int status=0;
		try
		{
			Connection con=getcon();
			PreparedStatement ps=con.prepareStatement("DELETE FROM register WHERE id=?");
			ps.setInt(1, u.getId());
			status=ps.executeUpdate();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static List<User>getAllRecords()
	{
		List<User> list=new ArrayList<User>();
		try
		{
			Connection con=getcon();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM register");
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setGender(rs.getString("gender"));
				u.setCountry(rs.getString("country"));
				list.add(u);
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	public static User getRecordById(int id)
	{
		User u=null;
		try
		{
		Connection con=getcon();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM register WHERE id=?");
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			u=new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setPassword(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setGender(rs.getString("gender"));
			u.setCountry(rs.getString("country"));
		}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return u;
	}
}
