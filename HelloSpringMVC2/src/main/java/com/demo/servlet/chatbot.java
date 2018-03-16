package com.demo.servlet;

import com.google.code.chatterbotapi.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.entity.chat;
//import com.fasterxml.jackson.core.JsonProcessingException;
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
        	String json = request.getParameter("data");
        	if(json!=null) {
        	    ObjectMapper mapper = new ObjectMapper();
                chat objChat = mapper.readValue(json, chat.class);
                ChatterBot bot2;
                String  s="";
				try {
					bot2 = factory.create(ChatterBotType.PANDORABOTS, "b0dafd24ee35a477");
					   ChatterBotSession bot2session = bot2.createSession();
					     s = bot2session.think(objChat.getChat());
			            System.out.println("bot2> " + s);
			            
			            
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        response.setContentType("application/json"); 
                response.setCharacterEncoding("utf-8"); 
                response.getWriter().println(s);
        	}
         
             
        
        }
} 