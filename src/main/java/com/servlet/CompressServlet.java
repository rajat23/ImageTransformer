package com.servlet;

import com.helper.ImageReader;
import com.helper.Response;
import com.utility.ImageCompresser;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class CompressServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getParameter("url");
        float quality = Float.parseFloat(request.getParameter("quality"));
        ImageReader imageReader = new ImageReader();
        BufferedImage image;

        try {
            image = imageReader.readImage(new URL(url));
        } catch (IOException ioException) {
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.write("<html><body>" + ioException.getMessage() + "</body><html>");
            return;
        }

        ImageCompresser imageCompresser = new ImageCompresser();
        image = imageCompresser.getCompressImage(image, quality);

        response.setContentType("image/jpeg");
        ImageIO.write(image, "jpg", response.getOutputStream());

    }


}