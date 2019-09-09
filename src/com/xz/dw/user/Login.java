package com.xz.dw.user;

import java.util.List;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.xz.dw.sql.SqlUtils;

@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long seialVersionUID = 1l;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServerException, IOException {
		//
		// String name = request.getParameter("name");
		// String psw = request.getParameter("psw");
		//
		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("name", name);
		// Map<String, Object> map1 = new HashMap<String, Object>();
		// map1.put("name", psw);
		// map1.put("age", 7);
		// Map<String, Object> map2 = new HashMap<String, Object>();
		// map2.put("name", "123");
		// map2.put("age", 10);
		// List<Map> jsonObjects = new ArrayList<Map>();
		// jsonObjects.add(map1);
		// jsonObjects.add(map2);
		// map.put("fans", jsonObjects);
		// response.getWriter().println(new JSONObject(map));
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServerException, IOException {
		// localhost:8080/DayWallpaper/login?

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String psw = request.getParameter("psw");
		System.out.println("----" + new Date() + "登录：------");
		System.out.println(id);
		System.out.println(psw);
		// SqlUtils.mloginSql(Token.getToken(id, psw));

//		Map<String, Object> m1 = new HashMap<>();
//		// 数据库操作-判断是否存在账号的token
//
//		try {
//			
//			JSONObject obj1 = new JSONObject(SqlUtils.mloginSql(Token.getToken(id, psw)));
//
//			if (obj1.getString("is_succeed").equals("T")) {
//				m1.put("is_succeed", "T");
//				m1.put("msg", "登录成功");
//				Map<String, Object> m2 = new HashMap<>();
//				m2.put("userName", "测试账号1");
//				m2.put("userNo", "admin");
//				m2.put("userPhoto", "https://www.z4a.net/images/2018/10/16/banner_intro.png");
//				m2.put("token", Token.getToken(id, psw));
//				m1.put("DATA", m2);
//
//			} else {
//				m1.put("is_succeed", "F");
//				m1.put("msg", "账号或密码错误");
//			}
//			
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		response.getWriter().println(new JSONObject(SqlUtils.mloginSql(Token.getToken(id, psw))));
	}

}
