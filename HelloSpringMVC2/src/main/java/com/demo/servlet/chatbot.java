package com.demo.servlet;

import com.google.code.chatterbotapi.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.entity.chat;
import com.demo.entity.json;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Servlet implementation class GetAllProducts
 */
@WebServlet("/chatbot")
public class chatbot extends HttpServlet {
        private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chatbot() {
        super();
        // TODO Auto-generated constructor stub
    }
   
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
          {
        	
        }
        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ChatterBotFactory factory = new ChatterBotFactory();
            String  s="";
            URL url = getClass().getResource("chat.json");
           String strurl = url.getPath();
//            File file2 = new File(url.getPath());
            JSONParser parser = new JSONParser();
            try {
			Object obj = parser.parse(new FileReader(strurl));
			JSONArray jsonObject = (JSONArray) obj;
			
			ArrayList<json> list = new ArrayList<json>();
			for (int i = 0; i < jsonObject.size(); i++) {
				String abcs = jsonObject.get(i).toString();
				ObjectMapper mapper = new ObjectMapper();
				json objTeacher = mapper.readValue(abcs, json.class);
				list.add(objTeacher);
	            
			}
		
				
			   	String json = request.getParameter("data");
	        	if(json!=null) {
	        	    ObjectMapper mapper = new ObjectMapper();
	                chat objChat = mapper.readValue(json, chat.class);
	                ChatterBot bot2;
	                for(int i=0;i<list.size();i++) {
	                	if(list.get(i).getKey().equals(objChat.getChat())) {
	                		s=list.get(i).getValue();
	                	}
	                }
	            
					
//						bot2 = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
//						   ChatterBotSession bot2session = bot2.createSession();
//						     s = bot2session.think(objChat.getChat());
//				            System.out.println("bot2> " + s);
			} 
            }catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
		        response.setContentType("application/json"); 
                response.setCharacterEncoding("utf-8"); 
                response.getWriter().println(s);
        	}
         
             
        
        
} 