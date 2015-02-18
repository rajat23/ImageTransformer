package com.helper;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Response {
    public void setResponse(HttpServletResponse response, BufferedImage image, String url) {
        FileUrl fileUrl = new FileUrl();
        String extension = fileUrl.getFileExtension(url);
        response.setContentType("image/" + extension);
        try {
            ImageIO.write(image, extension, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
