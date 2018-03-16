package com.demo.servlet;

 
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.tutorial.jdbc.ConnectionUtils;

import com.demo.entity.Student;
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
@WebServlet("/AddNewStudent")
public class AddStudents extends HttpServlet {
        private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudents() {
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
        	
        	String json = request.getParameter("test");
             List<Student> listStudent = new ArrayList<>();
             Gson gson = new Gson();
             ObjectMapper mapper = new ObjectMapper();
             Student objStudent = mapper.readValue(json, Student.class);
             
                    
             try {
            	  Connection conn = ConnectionUtils.getMyConnection();    
                 String sql = "Insert into Student(Name, StudentId, Class, Age,Sex) "
                         + " values (?,?,?,?,?) ";
                 // Create statement object
                 PreparedStatement stmt = conn.prepareStatement(sql);
        
                 // Set auto-commit to false
                 conn.setAutoCommit(false);
        
                 // Sét đặt các tham số.
                 stmt.setString(1,objStudent.getName());
                 stmt.setString(2,objStudent.getStudentId());
                 stmt.setString(3,objStudent.getClassA());
                 stmt.setString(4, objStudent.getAge());
                 stmt.setString(5, objStudent.getSex());
                 // Thêm vào lô.
                 stmt.addBatch();
                 int[] counts = stmt.executeBatch();
        
                 System.out.println("counts[1] = " + counts[0]);
        
                 // Explicitly commit statements to apply changes
                 conn.commit();
             } catch (Exception e) {
                 e.printStackTrace();
             }
        
        }
} 