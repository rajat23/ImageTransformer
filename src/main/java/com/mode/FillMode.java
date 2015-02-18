package com.mode;

import com.helper.CoordinateCalculator;
import com.helper.Coordinates;
import com.utility.ImageCropper;
import com.utility.RequestStructure;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class FillMode implements Mode {
    public BufferedImage getScaledImage(RequestStructure requestStructure) throws IOException {
        BufferedImage image=requestStructure.getImage();
        double aspectRatio=image.getWidth()/image.getHeight();
        int width=requestStructure.getWidth();
        int height=requestStructure.getHeight();
        if(width==0)
            width=(int)Math.ceil(height*aspectRatio);
        else if(height==0)
            height=(int)Math.ceil(width/aspectRatio);
        CoordinateCalculator coordinateCalculator=new CoordinateCalculator();

        Coordinates coordinates=coordinateCalculator.getCoordinates(image.getWidth(),image.getHeight(),width,height,requestStructure.getOrientation());
        ImageCropper imageCropper=new ImageCropper();
        return imageCropper.getCroppedImage(image,coordinates.getX(),coordinates.getY(),width,height);
    }
}
