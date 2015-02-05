package com.utility;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.net.URL;

public class CompressImage {

    public  static BufferedImage getCompressImage(String url,float factor) throws IOException {


        BufferedImage image = ImageIO.read(new URL(url));

        File compressedImageFile = new File("compress.jpg");
        OutputStream os =new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter>writers =  ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(factor);
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
        BufferedImage image1 =ImageIO.read(compressedImageFile);
        return image1;
    }
}