package MyProgect.Test;

public class Point3D extends Point2D{
   private int z;
    Point3D(int x, int y, int z){
        super(x, y);
        this.z = z;
    }
    @Override
   public String toString(){
        return x + "," + y + "," + z;
    }
}
