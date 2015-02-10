package com.utility;

import com.helper.FileUrl;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class ImageCompresserTest {

    @Test
    public void testConvertToRequiredFormat() throws Exception {
        String url="http://www.hdwallpapersinn.com/wp-content/uploads/2014/07/hd-Animals-Beautiful-Wallpaper.jpg";
        BufferedImage bufferedImage= ImageIO.read(new URL(url).openStream());
        ImageCompresser imageCompresser=new ImageCompresser();

        File file= imageCompresser.convertToRequiredFormat(bufferedImage,"png");
        assertEquals("png", new FileUrl().getFileExtension(file.getName()));

    }

    @Test
    public void testConvertToJpegImage() throws Exception {
        String url="http://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Papua_New_Guinea_(orthographic_projection).svg/541px-Papua_New_Guinea_(orthographic_projection).svg.png";
        BufferedImage bufferedImage = ImageIO.read(new URL(url).openStream());
        ImageCompresser imageCompresser=new ImageCompresser();

        File file= imageCompresser.convertToJpegImage(bufferedImage);
        assertEquals("jpg", new FileUrl().getFileExtension(file.getName()));

    }
}