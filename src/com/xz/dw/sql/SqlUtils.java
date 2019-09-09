package com.xz.dw.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class SqlUtils {
	// MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/daywallpaper?useSSL=false&serverTimezone=UTC";
	// 数据库的用户名与密码，需要根据自己的设置
	private static final String USER = "root";
	private static final String PASS = "123456";

	/**
	 * 登录查询sql
	 */
	public static  Map<String, Object> mloginSql(String mtoken){
		//待打包成json数据的集合
        Map<String, Object> m1 = new HashMap<>();
		 Connection conn = null;
	        Statement stmt = null;
	        int id =-1;
	        try{
	            // 注册 JDBC 驱动
	            Class.forName(JDBC_DRIVER);
	        
	            // 打开链接
	            System.out.println("连接数据库...");
	            conn = DriverManager.getConnection(DB_URL,USER,PASS);
	        
	           
	            stmt = conn.createStatement();
	            String sql;
	            // 执行查询
	            sql = "SELECT * FROM USER WHERE token = \""+mtoken+"\"";
	            ResultSet rs = stmt.executeQuery(sql);
	            
	            
	            
	            // 展开结果集数据库
	            while(rs.next()){
	                // 通过字段检索
	               id = rs.getInt("id");
	                String name = rs.getString("name");
	                String psw = rs.getString("psw");
	                String token = rs.getString("token");
	                String photo = rs.getString("photo");
	                String record_data = rs.getString("record_data");
	    
	                // 输出数据
	                System.out.println("ID: " + id);
	                System.out.println("name: " + name);
	                System.out.println("psw: " + psw);
	                System.out.println("photo: " + photo);
	                System.out.println("token: " + token);
	                System.out.println("record_data: " + record_data);
	                
	                Map<String, Object> m2 = new HashMap<>();
	                m2.put("userNo", id);
	                m2.put("userName", name);
	                m2.put("userPhoto", photo);
	                m2.put("token", token);
	                m1.put("DATA", m2);
	            }
	            
	           
	            // 完成后关闭
	            rs.close();
	            stmt.close();
	            conn.close();
	            System.out.println("关闭数据库...");
	        }catch(SQLException se){
	            // 处理 JDBC 错误
	            se.printStackTrace();
	        }catch(Exception e){
	            // 处理 Class.forName 错误
	            e.printStackTrace();
	        }finally{
	            // 关闭资源
	            try{
	                if(stmt!=null) stmt.close();
	            }catch(SQLException se2){
	            }// 什么都不做
	            try{
	                if(conn!=null) conn.close();
	            }catch(SQLException se){
	                se.printStackTrace();
	            }
	        }
	        System.out.println("----END-----");
	        //等于-1代表没有查询到 为空
	        if(id==-1){
	        	m1.put("is_succeed", "F");
	        	m1.put("msg", "账号或密码错误");
	        }else{
	        	m1.put("is_succeed", "T");
	        	m1.put("msg", "登录成功");
	        }
	    	return m1;
	}
	// /**
	// 备份
	// * 登录查询sql
	// */
	// public static void mloginSql(){
	//
	// Connection conn = null;
	// Statement stmt = null;
	// try{
	// // 注册 JDBC 驱动
	// Class.forName(JDBC_DRIVER);
	//
	// // 打开链接
	// System.out.println("连接数据库...");
	// conn = DriverManager.getConnection(DB_URL,USER,PASS);
	//
	//
	// stmt = conn.createStatement();
	// String sql;
	// // 执行查询
	// sql = "SELECT id, name, psw,token,record_data FROM user";
	// ResultSet rs = stmt.executeQuery(sql);
	//
	// // 展开结果集数据库
	// while(rs.next()){
	// // 通过字段检索
	// int id = rs.getInt("id");
	// String name = rs.getString("name");
	// String psw = rs.getString("psw");
	// String token = rs.getString("token");
	// String record_data = rs.getString("record_data");
	//
	// // 输出数据
	// System.out.println("ID: " + id);
	// System.out.println("name: " + name);
	// System.out.println("psw: " + psw);
	// System.out.println("token: " + token);
	// System.out.println("record_data: " + record_data);
	// }
	// // 完成后关闭
	// rs.close();
	// stmt.close();
	// conn.close();
	// }catch(SQLException se){
	// // 处理 JDBC 错误
	// se.printStackTrace();
	// }catch(Exception e){
	// // 处理 Class.forName 错误
	// e.printStackTrace();
	// }finally{
	// // 关闭资源
	// try{
	// if(stmt!=null) stmt.close();
	// }catch(SQLException se2){
	// }// 什么都不做
	// try{
	// if(conn!=null) conn.close();
	// }catch(SQLException se){
	// se.printStackTrace();
	// }
	// }
	// System.out.println("Goodbye!");
	// }
}
