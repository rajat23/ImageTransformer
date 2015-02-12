package com.servlet;


import com.helper.FileUrl;
import com.helper.ImageReader;
import com.helper.Response;
import com.utility.ImageScaler;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class ScaleServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getParameter("url");
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        ImageReader imageReader=new ImageReader();
        BufferedImage image;

        try {
            image = imageReader.readImage(new URL(url));
        } catch (IOException ioException) {
            response.setContentType("text/html");
            PrintWriter printWriter=response.getWriter();
            printWriter.write("<html><body>"+ioException.getStackTrace()+"</body><html>");
            return;
        }
        ImageScaler imageScaler=new ImageScaler();;
        image = imageScaler.resizeImage(image, width, height);

        Response servletResponse=new Response();
        servletResponse.setResponse(response, image, url);
    }



}
