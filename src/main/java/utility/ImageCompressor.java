package utility;

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

public class ImageCompressor {

    private ImageWriteParam param;
    private File compressedImageFile;
    private OutputStream os;
    private Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
    private ImageWriter writer;
    private ImageOutputStream ios;

    public ImageCompressor() {

        compressedImageFile = new File("compress.jpg");
        writers = ImageIO.getImageWritersByFormatName("jpg");
        writer = writers.next();

    }

    public BufferedImage getCompressImage(BufferedImage inputImage, float quality) throws IOException {
        if(quality==-1.0f)
            return inputImage;
        os = new FileOutputStream(compressedImageFile);
        ios = ImageIO.createImageOutputStream(os);
        writer.setOutput(ios);
        param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);
        writer.write(null, new IIOImage(inputImage, null, null), param);
        BufferedImage compressedImage = ImageIO.read(compressedImageFile);
        compressedImageFile.delete();
        closeStreams();
        return compressedImage;
    }

    private void closeStreams() throws IOException {
        os.close();
        ios.close();
        writer.dispose();
    }

}