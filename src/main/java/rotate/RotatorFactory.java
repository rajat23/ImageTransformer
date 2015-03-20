package rotate;


public class RotatorFactory {
    public Rotable create(String angle) {
        if(angle.equals("hflip"))
            return new Hflip();
        if(angle.equals("vflip"))
            return new Vflip();
        int tmpAngle=0;
        try{
            tmpAngle=Integer.parseInt(angle);
        }
        catch (Exception e){
            tmpAngle=0;
        }
        return new AngledFlip(tmpAngle);

    }
}
