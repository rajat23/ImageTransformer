package effect;

import java.awt.image.BufferedImage;

public class NoEffect implements Effectible {
    public BufferedImage getEffect(BufferedImage image) {
        return image;
    }
}
