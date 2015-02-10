package com.utility;


import java.awt.image.BufferedImage;
import java.io.*;

import java.util.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.net.URL;

public class ImageCompresser {
    
    public BufferedImage getCompressImage(String url, float quality) throws IOException {



        BufferedImage inputImage = ImageIO.read(new URL(url));
        File temporaryFile=new File("image.jpg");
        ImageIO.write(inputImage,"jpg",temporaryFile);
        inputImage=ImageIO.read(temporaryFile);
        temporaryFile.delete();
        File compressedImageFile = new File("compress.jpg");
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);
        writer.write(null, new IIOImage(inputImage, null, null), param);

        os.close();
        ios.close();
        writer.dispose();

        BufferedImage CompressedImage=ImageIO.read(compressedImageFile);
        temporaryFile=new File("image."+extension);
        ImageIO.write(CompressedImage,extension,temporaryFile);
        inputImage=ImageIO.read(new File("image."+extension));
        compressedImageFile.delete();
        temporaryFile.delete();
        return inputImage;
    }
}