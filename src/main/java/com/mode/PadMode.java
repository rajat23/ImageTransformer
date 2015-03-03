package com.mode;

import com.helper.CoordinateCalculator;
import com.helper.Coordinates;
import com.helper.RequestStructure;
import com.mode.strategies.Context;
import com.mode.strategies.ShrinkDimension;
import com.utility.ImageScaler;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PadMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image = requestStructure.getImage();
        Context context=new Context(new ShrinkDimension());
        Dimension dimension=context.executeStrategy(requestStructure.getDimension(),requestStructure.getAspectRatio());
        return drawImageWithPad(requestStructure, image, (int)dimension.getHeight(), (int) dimension.getWidth());
    }

    private BufferedImage drawImageWithPad(RequestStructure requestStructure, BufferedImage image, int height, int width) throws IOException {
        if(height==0&&width==0)
            return image;
        Coordinates coordinates = new CoordinateCalculator().getCoordinates(requestStructure.getWidth(), requestStructure.getHeight(), width,height, requestStructure.getOrientation());
        BufferedImage paddedImage = new BufferedImage(requestStructure.getWidth(), requestStructure.getHeight(), image.getType());
        Graphics graphics = paddedImage.getGraphics();
        graphics.setColor(requestStructure.getColor());
        graphics.fillRect(0, 0, requestStructure.getWidth(), requestStructure.getHeight());
        image=new ImageScaler().resizeImage(image,width,height);
        graphics.drawImage(image, coordinates.getX(), coordinates.getY(), null);
        graphics.dispose();
        return paddedImage;
    }
}
