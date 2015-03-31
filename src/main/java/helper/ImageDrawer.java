package helper;

import UserRequest.RequestList;
import helper.crop.coordinates.CropFactory;
import helper.crop.coordinates.Cropable;
import utility.ImageScaler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageDrawer {

    public BufferedImage drawImageWithPad(RequestList requestList, BufferedImage originalImage, int shrinkedHeight, int shrinkedWidth) throws IOException {
        if(shrinkedHeight==0&&shrinkedWidth==0)
            return originalImage;

        Coordinates cropCoordinates = new CropFactory().create(requestList.getOrientation()).getCoordinates(requestList.getResponseWidth(), requestList.getResponsHeight(), shrinkedWidth, shrinkedHeight);
        BufferedImage paddedImage = new BufferedImage(requestList.getResponseWidth(), requestList.getResponsHeight(), originalImage.getType());
        Graphics graphics = paddedImage.getGraphics();
        graphics.setColor(requestList.getColor());
        graphics.fillRect(0, 0, requestList.getResponseWidth(), requestList.getResponsHeight());
        BufferedImage scaledImage=new ImageScaler().resizeImage(originalImage,shrinkedWidth,shrinkedHeight);
        graphics.drawImage(scaledImage, cropCoordinates.getX(), cropCoordinates.getY(), null);
        graphics.dispose();
        return paddedImage;
    }

}
