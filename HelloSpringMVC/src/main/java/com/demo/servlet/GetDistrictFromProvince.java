package com.demo.servlet;

 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

 
/**
 * Servlet implementation class GetDistrictFromProvince
 */
@WebServlet("/GetDistrictFromProvince")
public class GetDistrictFromProvince extends HttpServlet {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDistrictFromProvince() {
        super();
        // TODO Auto-generated constructor stub
    }

 
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */ 
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                Map<Integer, String> listHN = new HashMap<Integer, String>();
                listHN.put(1, "Quan Ba Dinh");
                listHN.put(2, "Quan Cau Giay");
                listHN.put(3, "Quan Ha Ba Trung");
                listHN.put(4, "Huyen Soc Son");
                listHN.put(5, "Huyen Phuc Tho");
                
                Map<Integer, String> listHCM = new HashMap<Integer, String>();
                listHCM.put(1, "Quan 1");
                listHCM.put(2, "Quan 2");
                listHCM.put(3, "Quan Thu Duc");
                listHCM.put(4, "Huyen Cu Chi");
                listHCM.put(5, "Huyen Hoc Mon");
                
                Map<Integer, String> listDN = new HashMap<Integer, String>();
                listDN.put(1, "Quan Hai Chau");
                listDN.put(2, "Quan Thanh Khe");
                listDN.put(3, "Quan Son Tra");
                listDN.put(4, "Huyen Hoa Vang");
                listDN.put(5, "Huyen Hoang Sa");
                
                String proname = request.getParameter("proname");
                String json = null;             
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                if(proname.equals("Ha Noi")){
                        json = new Gson().toJson(listHN);
                }else if(proname.equals("TP. HCM")){
                        json = new Gson().toJson(listHCM);
                }else if(proname.equals("Da Nang")){
                        json = new Gson().toJson(listDN);
                }
                response.getWriter().write(json);
        }

 
        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                // TODO Auto-generated method stub
                doGet(request, response);
        }
} 