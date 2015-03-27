package UserRequest.requests;

import java.awt.image.BufferedImage;

public class InputImage {
    private BufferedImage image;
    private int width;
    private int height;
    private float aspectRatio;


    public InputImage(BufferedImage image){
        this.image = image;
        width = image.getWidth();
        height = image.getHeight();
        aspectRatio = (float) image.getWidth() / (float) image.getHeight();
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getAspectRatio() {
        return aspectRatio;
    }
}
