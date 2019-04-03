package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;


public class Logout extends HttpServlet{

	public Logout(){
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// Recuperer les parametres
		String key = request.getParameter("key");
		
		JSONObject ret = new JSONObject();
		// On appelle le service
		try{
			ret = services.User.logout(key);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		out.print(ret.toString());
	}
}