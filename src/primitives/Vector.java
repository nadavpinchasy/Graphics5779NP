package primitives;

import static java.lang.StrictMath.sqrt;
import java.util.Objects;

// the add and the sub is  NOT void - POint3D
// אthe add and the sub is NOT void - vector


public class Vector
{

    protected Point3D head;

    public void setHead(Point3D other)
    {
        if (other.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("It's not possibole to havae poin head that are (0,0,0)");
        }
        head=other;
    }
    public Point3D getHead()
    {
        return  head;
    }

    public Vector()// he will send an exception autumatic
    {
        setHead(new Point3D());
    }

    public  Vector(Point3D point)
    {
        if (point.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("It's not possibole to havae poin head that are (0,0,0)");
        }
        head=point;
    }

    public Vector(Point3D p1, Point3D p2) {

        if (p1.equals(p2)) {
            throw new IllegalArgumentException("pt1 == pt2 !!! nu nu nu");
        }
        setHead(new Point3D(
                p2.getX().subtract(p1.getX()),
                p2.getY().subtract(p1.getY()),
                p2.getZ().subtract(p1.getZ())));
    }

   public Vector(double x, double y, double z)
    {
        if (x==0 && y==0 && z==0)
        {
            throw new IllegalArgumentException("It's not possibole to havae poin head that are (0,0,0)");
        }
        this.head = new Point3D(x, y, z);
    }
    public Vector(Coordinate x, Coordinate y, Coordinate z)
    {
        if (x.get_coordinate()==0 && y.get_coordinate()==0 && z.get_coordinate()==0)
        {
            throw new IllegalArgumentException("It's not possibole to havae poin head that are (0,0,0)");
        }
        this.head = new Point3D(x, y, z);
    }

    public Vector(Vector other)
    {
        this.head=other.head;

    }

    @Override
    public String toString()
    {
        return "Vector{" + "head=" + getHead().toString() + '}';
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other) return true;
        if(other==null) return false;
        if (!(other instanceof Vector)) return false;
        Vector vector = (Vector) other;
        return getHead().equals(vector.getHead());
    }



    public Vector add(Vector vector2)
    {
        Point3D a = new Point3D(this.getHead().getX().add(vector2.getHead().getX()),
                this.getHead().getY().add(vector2.getHead().getY()),
                this.getHead().getZ().add(vector2.getHead().getZ()));
        Vector res=new Vector(a);
        return res;
    }

    public Vector subtract(Vector vector2)
    {
        Point3D a = new Point3D(this.getHead().getX().subtract(vector2.getHead().getX()),
                this.getHead().getY().subtract(vector2.getHead().getY()),
                this.getHead().getZ().subtract(vector2.getHead().getZ()));
        Vector res=new Vector(a);
        return res;
    }


    public Vector scale(double scalingFactor)
    {
        Coordinate x1 = new Coordinate(this.head .getX().get_coordinate());
        x1.set_coordinate(x1.get_coordinate()* scalingFactor);

//        this.head.setX(x1);

        Coordinate x2 = new Coordinate(this.head.getY().get_coordinate());
        x2.set_coordinate(x2.get_coordinate() * scalingFactor);

  //      this.head.setY(x2);

        Coordinate x3 = new Coordinate(this.head.getZ().get_coordinate());
        x3.set_coordinate(x3.get_coordinate() * scalingFactor);

    //    this.head.setZ(x3);

    Vector res =new Vector(x1,x2,x3);//
    return res;  //

    }


    public double length()
    {
        double x = this.getHead().getX().get_coordinate();
        double y = this.getHead().getY().get_coordinate();
        double z = this.getHead().getZ().get_coordinate();

        return Math.sqrt(Util.uadd(Util.uadd(Util.uscale(x, x), Util.uscale(y, y)), Util.uscale(z, z)));
    }




    public void normalize()
    {

        double length = this.length();

        if (length == 0)
            throw new ArithmeticException();

        this.setHead(new Point3D(
                new Coordinate(this.getHead().getX().get_coordinate() / length),
                new Coordinate(this.getHead().getY().get_coordinate() / length),
                new Coordinate(this.getHead().getZ().get_coordinate() / length)));
    }




    public double dotProduct(Vector vector) {
        double u1 = this.head.getX().get_coordinate();
        double u2 = this.head.getY().get_coordinate();
        double u3 = this.head.getZ().get_coordinate();
        double v1 = vector.head.getX().get_coordinate();
        double v2 = vector.head.getY().get_coordinate();
        double v3 = vector.head.getZ().get_coordinate();
        return Util.uadd(Util.uadd(Util.uscale(u1, v1), Util.uscale(u2, v2)), Util.uscale(u3, v3));
    }


    public Vector crossProduct(Vector vector)
    {

        double x1 = this.getHead().getX().get_coordinate();
        double y1 = this.getHead().getY().get_coordinate();
        double z1 = this.getHead().getZ().get_coordinate();

        double x2 = vector.getHead().getX().get_coordinate();
        double y2 = vector.getHead().getY().get_coordinate();
        double z2 = vector.getHead().getZ().get_coordinate();

        return new Vector(   new Point3D(
                new Coordinate(Util.usubtract(Util.uscale(y1, z2), Util.uscale(z1, y2))) ,
                new Coordinate(Util.usubtract(Util.uscale(z1, x2), Util.uscale(x1, z2))) ,
                new Coordinate(Util.usubtract(Util.uscale(x1, y2), Util.uscale(y1, x2))))  );
    }

}


