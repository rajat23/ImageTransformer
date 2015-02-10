package com.servlet;


import com.helper.FileUrl;
import com.utility.ImageScaler;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ScaleServlet extends HttpServlet {


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        String url = request.getParameter("url");
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        BufferedImage image = null;

        try {

            image = ImageScaler.resizeImage(url, width, height);

        } catch (Exception e) {
            e.printStackTrace();
        }
        FileUrl fileUrl=new FileUrl();
        String extension=fileUrl.getFileExtension(url);
        response.setContentType("image/"+extension);
        ImageIO.write(image, extension, response.getOutputStream());
    }

    public void destroy() {
    }

}
