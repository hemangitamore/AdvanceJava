package com.studentCrud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.tomcat.dbcp.dbcp2.ConnectionFactory;

import com.studentCrud.model.Student;


public class sqlUtil {
	final static String DB_NAME="school";
	final static String DB_USER="root";
	final static String DB_PASSWORD="root";
	final static String DB_URL="jdbc:mysql://localhost:3306/"+DB_NAME;
	final static String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	public static Connection conn;
	public static PreparedStatement stmt;
	
 public	static void DbConnect() throws ClassNotFoundException, SQLException {
	 Class.forName(JDBC_DRIVER);
	 conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);

 }
 
 static public int insert(Student student) throws SQLException {
	 int result=-1;
	 result= stmt.executeUpdate();
	 return result;
	 
 }
 
  static public ResultSet fetch() throws SQLException {
	 ResultSet rs=null;
	 return stmt.executeQuery();
	 
	 
 }
  
  static public int update() throws SQLException {
	  int result=-1;
	  result=stmt.executeUpdate();
	  return result;
  }
  
  static public int delete() throws SQLException {
	  int result=-1;
	  result=stmt.executeUpdate();
	  return result;
  }
  
  static public void close() throws SQLException {
	  if(conn!=null && stmt!=null);
	 conn.close();
	 stmt.close();
	 
  }
 
 
	

}
