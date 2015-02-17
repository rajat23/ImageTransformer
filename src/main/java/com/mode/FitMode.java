package com.mode;

import com.utility.ImageStructure;

import java.awt.image.BufferedImage;

public class FitMode implements Mode {
    public ImageStructure getDimensions(BufferedImage image, ImageStructure imageStructure){
        int originalHeight=image.getHeight();
        int originalWidth=image.getWidth();
        float originalAspectRatio=(float)originalWidth/(float)originalHeight;
        int height=imageStructure.getHeight();
        int width=imageStructure.getWidth();
        if(height==0) {
            height = (int) (width / originalAspectRatio);

        }
        else if(width==0){
            width = (int) (height * originalAspectRatio);

        }

        else  if((width/height)!=originalAspectRatio) {
            if (height>width)
                height = (int)(width / originalAspectRatio);
            else
                width =(int)(height*originalAspectRatio);
        }

        return new ImageStructure(0,0,width,height);


    }
}
