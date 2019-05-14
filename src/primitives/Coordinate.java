package primitives;

import java.awt.*;

import static primitives.Util.*;

public class Coordinate
{
    //private static final double EPSILON = 0.0000001;
    protected double _coordinate;
    public static Coordinate ZERO = new Coordinate(0.0);



    /////////////////////////////-ctor-/////////////////////////
      public Coordinate()
    {
      this._coordinate=0.0;
    }
    public Coordinate(double coordinate)
    {
        // if it too close to zero make it zero
        _coordinate = Util.alignZero(coordinate);
    }
    public Coordinate(Coordinate other)
    {
        _coordinate = other._coordinate;
    }


    public void set_coordinate(double _coordinate) {
        this._coordinate = _coordinate;
    }
    public static Coordinate getZERO() {
        return ZERO;
    }
    public double get_coordinate() {
        return _coordinate;
    }

    @Override
    public boolean equals(Object other)
    {
        if (this==other) return true;
        if  (other == null) return false;
        if (!(other instanceof Coordinate)) return false;
        return Util.usubtract(_coordinate, ((Coordinate)other)._coordinate) == 0.0;
    }

    @Override
    public String toString()
    {
            return "cordinate: " + _coordinate;
    }

    public Coordinate subtract(Coordinate other) {
        return new Coordinate(Util.usubtract(_coordinate, other._coordinate));
    }

    public Coordinate add(Coordinate other)
    {
        return new Coordinate(Util.uadd(_coordinate, other._coordinate));
    }


}
