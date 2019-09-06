

import java.util.List;
import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	private static final long seialVersionUID = 1l;
	protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException{
		
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("name", psw);
		map1.put("age", 7);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "Ð¡ÄáÂê");
		map2.put("age", 10);
		List<Map> jsonObjects = new ArrayList<Map>();
		jsonObjects.add(map1);
		jsonObjects.add(map2);
		map.put("fans", jsonObjects);
		response.getWriter().println(new JSONObject(map));
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServerException,IOException{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String psw = request.getParameter("psw");
		System.out.println(name);
		System.out.println(psw);
		
		Map<String,Object> m1 = new HashMap<>();
		if(name.equals("admin")&&psw.equals("123456")){
			m1.put("is_succeed", "T");
			m1.put("msg", "µÇÂ¼³É¹¦");
		}else{
			m1.put("is_succeed", "F");
			m1.put("msg", "ÕËºÅ»òÃÜÂë´íÎó");
		}
		response.getWriter().println(new JSONObject(m1));
	}
	
}

