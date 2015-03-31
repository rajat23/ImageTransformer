package helper;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Response {
    public void setResponse(HttpServletResponse response, BufferedImage image, String format) {

        response.setContentType("image/" + format);
        try {
            ImageIO.write(image, format, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
