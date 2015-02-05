package com.servlet;



import com.utility.CompressImage;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ServletCompress extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        String url=request.getParameter("url");
        float factor = Float.parseFloat(request.getParameter("factor"));
        BufferedImage image = null;

        try {
            image = CompressImage.getCompressImage(url,factor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    public void destroy() {
    }
}