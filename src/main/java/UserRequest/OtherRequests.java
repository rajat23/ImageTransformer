package UserRequest;

public class OtherRequests {
    private int radius;
    private String effect;
    private String angle;
    private String format;
    private float quality;

    public int getRadius() {
        return radius;
    }

    public String getEffect() {
        return effect;
    }

    public String getAngle() {
        return angle;
    }

    public String getFormat() {
        return format;
    }

    public float getQuality() {
        return quality;
    }

    public OtherRequests(int radius, String effect, String angle, String format, float quality) {

        this.radius = radius;
        this.effect = effect;
        this.angle = angle;
        this.format = format;
        this.quality = quality;
    }
}
