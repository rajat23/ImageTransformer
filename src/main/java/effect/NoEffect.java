package effect;

import java.awt.image.BufferedImage;

public class NoEffect implements Effectible {
    @Override
    public BufferedImage getEffect(BufferedImage image) {
        return image;
    }
}
