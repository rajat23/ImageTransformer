package com.servlet;

import com.helper.FileUrl;
import com.utility.ImageCropper;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class CropServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int xCoordinate = Integer.parseInt(request.getParameter("x"));
        int yCoordinate = Integer.parseInt(request.getParameter("y"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        String url = request.getParameter("url");
        BufferedImage image = null;
        ImageCropper imageCropper=new ImageCropper();
        try {
            image = imageCropper.getCroppedImage(url, xCoordinate, yCoordinate, width, height);
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
