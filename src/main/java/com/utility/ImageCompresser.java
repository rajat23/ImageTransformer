package com.utility;


import com.helper.FileUrl;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;
import java.net.URL;

public class ImageCompresser {

    public BufferedImage getCompressImage(String url, float quality) throws IOException {

        BufferedImage inputImage = ImageIO.read(new URL(url));
        String extension = getFileExtension(url);
        BufferedImage jpegImage = convertToJpegImage(inputImage);

        File compressedImageFile = compressFile(quality, jpegImage);

        BufferedImage compressedImage=ImageIO.read(compressedImageFile);
        compressedImage=convertToRequiredFormat(compressedImage,extension);
        compressedImageFile.delete();

        return compressedImage;
    }

    private File compressFile(float quality, BufferedImage jpegImage) throws IOException {
        File compressedImageFile = new File("compress.jpg");
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);
        writer.write(null, new IIOImage(jpegImage, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
        return compressedImageFile;
    }

    private BufferedImage convertToRequiredFormat(BufferedImage compressedImage,String extension) throws IOException{
        File temporaryFile=new File("image."+extension);
        ImageIO.write(compressedImage,extension,temporaryFile);
        compressedImage=ImageIO.read(new File("image."+extension));
        temporaryFile.delete();
        return compressedImage;
    }

    private BufferedImage convertToJpegImage(BufferedImage inputImage) throws IOException {
        File temporaryFile=new File("image.jpg");
        ImageIO.write(inputImage, "jpg", temporaryFile);
        BufferedImage jpegImage=ImageIO.read(temporaryFile);
        temporaryFile.delete();
        return jpegImage;
    }

    private String getFileExtension(String url) {
        FileUrl fileUrl=new FileUrl();
        return fileUrl.getFileExtension(url);
    }
}