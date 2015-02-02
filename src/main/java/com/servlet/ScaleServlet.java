package com.servlet;

import com.utility.ImageScale;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ScaleServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        int width = Integer.parseInt(request.getParameter("width"));
        String url=request.getParameter("url");
        BufferedImage image = null;
        try {
            image = ImageScale.getScaledImage(url,width);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    public void destroy() {
    }
}