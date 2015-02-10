package com.utility;


import com.helper.FileUrl;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;

public class ImageCompresser {

    public BufferedImage getCompressImage(String url, float quality) throws IOException {

        BufferedImage inputImage = ImageIO.read(new URL(url).openStream());
        String extension = getFileExtension(url);

        File jpegImageFile= convertToJpegImage(inputImage);
        BufferedImage jpegImage = ImageIO.read(jpegImageFile);
        jpegImageFile.delete();

        File compressedImageFile = compressFile(quality, jpegImage);

        BufferedImage compressedImage = ImageIO.read(compressedImageFile);
        compressedImageFile.delete();
        compressedImageFile = convertToRequiredFormat(compressedImage, extension);
        compressedImage = ImageIO.read(compressedImageFile);

        compressedImageFile.delete();

        return compressedImage;
    }

    public File compressFile(float quality, BufferedImage jpegImage) throws IOException {
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

    public File convertToRequiredFormat(BufferedImage compressedImage, String extension) throws IOException {
        File temporaryFile = new File("image." + extension);
        ImageIO.write(compressedImage, extension, temporaryFile);
        return temporaryFile;
    }

    public File convertToJpegImage(BufferedImage inputImage) throws IOException {
        File temporaryFile = new File("image.jpg");
        ImageIO.write(inputImage, "jpg", temporaryFile);
        return temporaryFile;
    }

    private String getFileExtension(String url) {
        FileUrl fileUrl = new FileUrl();
        return fileUrl.getFileExtension(url);
    }
}