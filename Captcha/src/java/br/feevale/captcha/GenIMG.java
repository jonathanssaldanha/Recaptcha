/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.feevale.captcha;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GenIMG extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/png");
        try{
            HttpSession sess = request.getSession();
            BufferedImage img = new BufferedImage(50, 30, BufferedImage.TYPE_INT_RGB);
            
            Graphics2D g = img.createGraphics();
            
            // gerar um codigo aleatorio a partir da data/hora
            Integer val = (int)(Math.random()*1000);
            
            // salvar o codigo gerado na variavel de sessão
            sess.setAttribute("CODE", val.toString());
            
            g.setColor(Color.WHITE);
            g.drawString(val.toString(), 10, 20);
            g.dispose();
            
            ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
            ImageIO.write(img, "png", bytesOut);
            
            response.setHeader("Content-Lenght:", bytesOut.size() + " ");
            response.getOutputStream().write(bytesOut.toByteArray());
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
