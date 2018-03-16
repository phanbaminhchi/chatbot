package com.demo.servlet;

 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.o7planning.tutorial.jdbc.ConnectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.Student;
import com.demo.entity.User;
//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import jdk.nashorn.internal.parser.JSONParser;
/**
 * Servlet implementation class GetAllProducts
 */
@WebServlet("/login")

public class LoginUser extends HttpServlet {
        private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
        // TODO Auto-generated constructor stub
    }
   
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
          {
        	String json = request.getParameter("data");
            Gson gson = new Gson();
            ObjectMapper mapper = new ObjectMapper();
            User objTeacher = mapper.readValue(json, User.class);
            
                   
            try {
           	  Connection conn = ConnectionUtils.getMyConnection();    
                String sql = "Select username from userTeacher emp  where emp.username like ? and emp.password = ? ";
                // Create statement object
                PreparedStatement stmt = conn.prepareStatement(sql);
       
                // Set auto-commit to false
                conn.setAutoCommit(false);
                stmt.setString(1, objTeacher.getUsername());
                // Sét đặt giá trị tham số thứ hai (Dấu ? thứ hai)
                stmt.setString(2, objTeacher.getPassword());
                // Sét đặt các tham số.
                // Thêm vào lô.
                stmt.addBatch();
                ResultSet rs = stmt.executeQuery();
       
                while (rs.next()) {
                    System.out.println(" ---- ");
                    System.out.println("username : " + rs.getString("username"));
                    
                }
                response.setContentType("application/json"); 
                response.setCharacterEncoding("utf-8"); 
                response.getWriter().println(objTeacher.getUsername());
                // Explicitly commit statements to apply changes
            } catch (Exception e) {
                e.printStackTrace();
            }  
          }

   

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
        	String json = request.getParameter("data");
             Gson gson = new Gson();
             ObjectMapper mapper = new ObjectMapper();
             User objTeacher = mapper.readValue(json, User.class);
             
                    
             try {
            	  Connection conn = ConnectionUtils.getMyConnection();    
                 String sql = "Select username from userTeacher emp  where emp.username like ? and emp.password = ? ";
                 // Create statement object
                 PreparedStatement stmt = conn.prepareStatement(sql);
        
                 // Set auto-commit to false
                 conn.setAutoCommit(false);
                 stmt.setString(1, objTeacher.getUsername());
                 // Sét đặt giá trị tham số thứ hai (Dấu ? thứ hai)
                 stmt.setString(2, objTeacher.getPassword());
                 // Sét đặt các tham số.
                 // Thêm vào lô.
                 stmt.addBatch();
                 ResultSet rs = stmt.executeQuery();
        
                 while (rs.next()) {
                     System.out.println(" ---- ");
                     System.out.println("username : " + rs.getString("username"));
                     
                 }
                
                 // Explicitly commit statements to apply changes
             } catch (Exception e) {
                 e.printStackTrace();
             }  
             
             response.setContentType("application/json"); 
             response.setCharacterEncoding("utf-8"); 
             
             response.getWriter().println(objTeacher.getUsername());
             System.out.println();
        }
} 