package primitives;

import static primitives.Util.*;
import java.util.Objects;


public class Point2D
{
    protected Coordinate x;
    protected Coordinate y;


    public void setX(Coordinate x)
    {
        this.x = x;
    }
    public void setY(Coordinate y) {
        this.y = y;
    }
    public Coordinate getX() {
        return x;
    }
    public Coordinate getY() {
        return y;
    }

    public Point2D()
    {
        setX(Coordinate.ZERO);
        setY(Coordinate.ZERO);
    }
    public Point2D(Coordinate x, Coordinate y)
    {
        super();
        this.setX(x);
        this.setY(y);
    }
    public Point2D(double _x, double _y) {
       x.set_coordinate(_x);
       y.set_coordinate(_y);
    }
    public Point2D(Point2D other)
    {
        x = other.x;
        y = other.y;
    }

    @Override
    public boolean equals(Object other)
    {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof Point2D)) return false;
        Point2D point2D = (Point2D) other;
        return getX().equals(point2D.getX()) &&
                getY().equals(point2D.getY());

    }

    @Override
    public String toString()
    {
        return "Point2D{" + "x=" + getX() + ", y=" + getY() + '}';
    }



}
