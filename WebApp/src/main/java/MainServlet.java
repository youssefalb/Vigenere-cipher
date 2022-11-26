/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.polsl.youssef.albali.vigenere.cipher.model.EmptyKey;
import pl.polsl.youssef.albali.vigenere.cipher.model.InvalidCharacterException;
import pl.polsl.youssef.albali.vigenere.cipher.model.VigenereCipherModel;
/**
 *
 * @author youssef albali
 */
@WebServlet(name = "Main" ,urlPatterns = {"/Main"})
public class MainServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        String opBtn = request.getParameter("btn");
        String htmlRespone = "<html>";
        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        Integer errorCount = 0;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("errorCount")) {
                    errorCount = Integer.valueOf(cookie.getValue());
                    break;
                }
            }
        }
        
        Integer counter = (Integer) session.getAttribute("counter");
         if (counter == null) 
            {
                counter = 1;
            } else 
            {
                counter = counter + 1;
            }

        session.setAttribute("counter", counter);
    try{

        if (opBtn.equals("Encrypt")){
                String message = request.getParameter("message");
                String key = request.getParameter("encryptionKey");
                VigenereCipherModel vig = new VigenereCipherModel(key);
                String result = String.join(" ",vig.getEncryptedMessage(Stream.of(message.split(" "))));
                htmlRespone += "<h2>Your message is: " + message + "<br/>";      
                htmlRespone += "Your password is: " + key + "<br/>";    
                htmlRespone += "Encryption Result is: " + result + "</h2>";
                htmlRespone += "</html>";
                writer.println(htmlRespone); 
            }
        else if (opBtn.equals("Decrypt")){

            String ciphertext = request.getParameter("cipherText");
            String key = request.getParameter("decryptionKey");
            VigenereCipherModel vig = new VigenereCipherModel(key);
            String result = String.join(" ",vig.getDecryptedMessage(Stream.of(ciphertext.split(" "))));
            htmlRespone += "<h2>Your message is: " + ciphertext + "<br/>";      
            htmlRespone += "Your password is: " + key + "<br/>";    
            htmlRespone += "Decryption Result is: " + result + "</h2>";
            //htmlRespone += "</html>";
            writer.println(htmlRespone); 
        }
        
    }
    catch(EmptyKey | InvalidCharacterException ex){
        errorCount++;
        Cookie cookie = new Cookie("errorCount", errorCount.toString());
        response.addCookie(cookie);
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());        
        
        }        
        writer.println("<h3>Total errors: " + errorCount + "</h3>");

        writer.print("</html>");

      //  getServletContext().getRequestDispatcher("/History").include(request, response);
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
