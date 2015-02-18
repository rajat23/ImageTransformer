package com.mode;

import com.utility.RequestStructure;

import java.awt.image.BufferedImage;

public class LimitMode implements Mode {
    public RequestStructure getDimensions(BufferedImage image, RequestStructure requestStructure) {
        if (requestStructure.getHeight() > image.getHeight() || requestStructure.getWidth() > image.getWidth())
            return new RequestStructure(0, 0, image.getWidth(), image.getHeight());

        return new FitMode().getDimensions(image, requestStructure);

    }
}

