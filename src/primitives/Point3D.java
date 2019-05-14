package primitives;

import static java.lang.StrictMath.sqrt;
import java.util.Objects;

public class Point3D extends Point2D {
    Coordinate z;
    public static final Point3D ZERO = new Point3D();


    public Point3D() {
       /*setX(Coordinate.ZERO);
        setY(Coordinate.ZERO);
    */
        super();
        z = Coordinate.ZERO;
    }


    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(double x, double y, double z) {
        setX(new Coordinate(x));
        setY(new Coordinate(y));
        setZ(new Coordinate(z));
    }

    public Point3D(Point3D other) {
        super();
        this.setX(other.getX());
        this.setY(other.getY());
        this.setZ(other.getZ());
    }


    public void setZ(Coordinate z)
    {
        this.z = z;
    }

    public Coordinate getZ() {
        return z;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof Point3D)) return false;
        if (!super.equals(other)) return false;
        Point3D point3D = (Point3D) other;
        return getZ().equals(point3D.getZ());
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + super.getX() +
                ", y=" + super.getY() +
                ", z=" + getZ() +
                '}';
    }




    public Point3D add(Vector vector) {

       Point3D nouveau = new Point3D( this.x.add(vector.getHead().getX()),
        this.y.add(vector.getHead().getY()),
        this.z.add(vector.getHead().getZ()));

        return nouveau;
}

    public Vector subtract(Point3D point)
    {
        return new Vector(point,this);
    }


    public Point3D subtract(Vector v) {
        Point3D p_vec = v.getHead();

        Point3D result = new Point3D(
                this.getX().subtract(p_vec.getX()),
                this.getY().subtract(p_vec.getY()),
                this.getZ().subtract(p_vec.getZ()));

        return result;
    }

    public double distance(Point3D other)
    {
        double a= Util.usubtract(other.getX().get_coordinate() ,this.getX().get_coordinate());
        double x1= Util.uscale(a,a);
        double b= Util.usubtract(other.getY().get_coordinate() ,this.getY().get_coordinate());
        double y1= Util.uscale(b,b);
        double c= Util.usubtract(other.getZ().get_coordinate() ,this.getZ().get_coordinate());
        double z1= Util.uscale(c,c);
        return Math.sqrt(Util.uadd(x1,Util.uadd(y1,z1)));
    }

}
