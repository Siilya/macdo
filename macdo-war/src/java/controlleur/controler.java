/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import controlleur.secondaires.sousController;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi312
 */
public class controler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
     HashMap<String, sousController> map;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        map = new HashMap();
        for (Enumeration<String> e = this.getInitParameterNames();
                e.hasMoreElements();) {
            String name = e.nextElement();
            String value = this.getInitParameter(name);
//            System.out.println(">>>"+ name+"/"+value);
            try {
                sousController s = (sousController) Class.forName(value).newInstance();
                map.put(name, s);
            } catch (ClassNotFoundException ex) {
                System.out.println("ClassNotFound>>>>" + ex.getMessage());
            } catch (InstantiationException ex) {
                System.out.println("Instantiation>>>>" + ex.getMessage());
            } catch (IllegalAccessException ex) {
                System.out.println("IllegalAccess>>>>" + ex.getMessage());
            }
        }
//        System.out.println(">>>>"+ map.size());
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        String url = "/WEB-INF/home.jsp";

        if (request.getParameter("section") != null) {
            String name = request.getParameter("section");
//            System.out.println(">>>>>><"+ name);
            if (map.containsKey(name)) {
                sousController s = map.get(name);
                url = s.execute(request, response);
            }
        }

        request.getRequestDispatcher(url).include(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
