package com.utility;


import com.helper.ImageFormatConverter;

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
import java.util.Iterator;

public class ImageCompresser {
    private ImageWriteParam param;

    public BufferedImage getCompressImage(BufferedImage inputImage, float quality,String extension) throws IOException {

        ImageFormatConverter imageFormatConverter=new ImageFormatConverter();
        BufferedImage jpegImage = imageFormatConverter.convertToRequiredFormat(inputImage, "jpg");
        BufferedImage compressedImage = compressJpegFile(jpegImage, quality);
        compressedImage = imageFormatConverter.convertToRequiredFormat(compressedImage, extension);
        return compressedImage;
    }

    public BufferedImage compressJpegFile(BufferedImage jpegImage,float quality) throws IOException {
        File compressedImageFile = new File("compress.jpg");
        OutputStream os = new FileOutputStream(compressedImageFile);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);

        param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);
        writer.write(null, new IIOImage(jpegImage, null, null), param);

        os.close();
        ios.close();
        writer.dispose();
        BufferedImage compressedJpegImage=ImageIO.read(compressedImageFile);
        compressedImageFile.delete();
        return compressedJpegImage;
    }
    public float getQuality(){
       return param.getCompressionQuality();
    }
}