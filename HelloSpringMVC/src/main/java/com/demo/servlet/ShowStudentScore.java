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
import com.demo.entity.StudentScore;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import java.sql.ResultSet;
import java.sql.Statement;
 
/**
 * Servlet implementation class GetAllProducts
 */
@WebServlet("/ShowStudentScore")
public class ShowStudentScore extends HttpServlet {
        private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentScore() {
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
        	System.out.println("Get connection ... ");
        	 try {
                 Connection conn = ConnectionUtils.getMyConnection();
				
				  System.out.println("Get connection " + conn);
				 Statement statement = conn.createStatement();
	        	 
	             String sql = "Select StudentId,KanjiScore,GoiScore,level,date,time from ScoreStudent";
	        
	             ResultSet rs = statement.executeQuery(sql);
	             List<StudentScore> listStudentScore = new ArrayList<>();
	             
	             while (rs.next()) {
	            	 StudentScore obj = new StudentScore( );
	                 String stuId = rs.getString("StudentId");
	                 String kanjiScore = rs.getString("KanjiScore");
	                 String goiScore = rs.getString("GoiScore");
	                 String level = rs.getString("level");
	                 String date = rs.getString("date");
	                 String time = rs.getString("time");
	                 
	                 obj.setTimes(time);
	                 obj.setDatepicker(date);
	                 obj.setLevel(level);
	                 obj.setGoiScore(goiScore);
	                 obj.setStudentId(stuId);
	                 obj.setKanjiScore(kanjiScore);
	                 listStudentScore.add(obj);
	             }
                 Gson gson = new Gson();
                 JsonElement element = gson.toJsonTree(listStudentScore, new TypeToken<List<Student>>(){}.getType());
                 JsonArray jsonArray = element.getAsJsonArray();
                 response.setContentType("application/json");
                 response.getWriter().println(jsonArray);
	             
	             conn.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}  // TODO Auto-generated method stub
        }
} 