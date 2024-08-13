package org.hotel.config;

import java.util.*;
import java.sql.*;

public class DBConfig {

	private static Connection c;
	private static PreparedStatement ps;
	private static ResultSet rs;

	private static DBConfig db=null;
	
	private DBConfig()
	{
		try {
			
			Properties p=new Properties();
			p.load(PathHelper.fs);
			
			String DriverClassName=p.getProperty("db.Driver");
			String Username=p.getProperty("db.Username");
			String Password=p.getProperty("db.Password");
			String Url=p.getProperty("db.Url");
			
			Class.forName(DriverClassName);
			c=DriverManager.getConnection(Url,Username,Password);
			
//			if(c!=null)
//			{
//				System.out.println("The Data base is connected");
//			}
//			else
//			{
//				System.out.println("The data base is not connected");
//			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error in DBConfig"+e);
		}
	}
	public static DBConfig getInstance()
	{
		if(db==null)
		{
			db=new DBConfig();
		}
		return db;
	}
	public static Connection getConnection()
	{
		return c;
	}
	public static PreparedStatement getStatement()
	{
		return ps;
	}
	public static ResultSet getResultSet()
	{
		return rs;
	}
}