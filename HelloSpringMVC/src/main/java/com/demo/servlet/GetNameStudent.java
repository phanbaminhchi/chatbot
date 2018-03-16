package com.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entity.Product;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class GetNameStudent {
	@WebServlet("/GetStudent")
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
	        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                // TODO Auto-generated method stub
	                List<Product> listPro = new ArrayList<>();
	                listPro.add(new Product("P01", "Ti vi", "Toshiba", 2015, 5000000));
	                listPro.add(new Product("P02", "Tu lanh", "Sanyo", 2016, 8000000));
	                listPro.add(new Product("P03", "Dieu hoa", "Daikin", 2017, 12000000));
	                listPro.add(new Product("P04", "O to CRV", "Honda", 2016, 900000000));
	                listPro.add(new Product("P05", "May tinh", "Acer", 2015, 10000000));
	                
	                Gson gson = new Gson();
	                JsonElement element = gson.toJsonTree(listPro, new TypeToken<List<Product>>(){}.getType());
	                JsonArray jsonArray = element.getAsJsonArray();
	                response.setContentType("application/json");
	                response.getWriter().println(jsonArray);
	        }

	 
	        /**
	         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	         */
	        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	                // TODO Auto-generated method stub
	                doGet(request, response);
	        }
}
}