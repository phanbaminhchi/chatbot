package com.demo.servlet;

 
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.tutorial.jdbc.ConnectionUtils;

import com.demo.entity.Product;
import com.demo.entity.Student;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.sql.Statement;
 
/**
 * Servlet implementation class GetAllProducts
 */
@WebServlet("/GetAllStudents")
public class GetAllStudents extends HttpServlet {
        private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllStudents() {
        super();
        // TODO Auto-generated constructor stub
    }
   
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
          {
        	System.out.println("Get connection ... ");
        	 try {
                 Connection conn = ConnectionUtils.getMyConnection();
				
				  System.out.println("Get connection " + conn);
				 Statement statement = conn.createStatement();
	        	 
	             String sql = "Select StudentId,Name,Age,Class,Sex from Student";
	        
	             ResultSet rs = statement.executeQuery(sql);
	             List<Student> listStudent = new ArrayList<>();
	             
	             while (rs.next()) {
	            	 Student obj = new Student( );
	                 String stuId = rs.getString("StudentId");
	                 String stuName = rs.getString("Name");
	                 String stuAge = rs.getString("Age");
	                 String stuClass = rs.getString("Class");
	                 String stuSex = rs.getString("Sex");
	                 obj.setName(stuName);
	                 obj.setClassA(stuClass);
	                 obj.setAge(stuAge);
	                 obj.setSex(stuSex);
	                 obj.setStudentId(stuId);
	                 listStudent.add(obj);
	             }
                 Gson gson = new Gson();
                 JsonElement element = gson.toJsonTree(listStudent, new TypeToken<List<Student>>(){}.getType());
                 JsonArray jsonArray = element.getAsJsonArray();
                 response.setContentType("application/json");
                 response.getWriter().println(jsonArray);
	             
	             conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
        }
        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }
} 