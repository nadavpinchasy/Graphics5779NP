package primitives;

import java.util.Objects;

import static java.lang.StrictMath.sqrt;

public class Ray {

    Point3D _POO;    // (I chose those name since this is how its called in the slides of dr. ezra )
    Vector _direction;


    public void Ray()  // default ctor
    {
        set_direction(new Vector());
    }
    public void Ray(Point3D _p,Vector _d )// ctor that get a point and a vector
    {

        this.set_direction(new Vector (_d));
        this.set_POO(new Point3D(_p));
    }
    public  void Ray(Ray other)// copy ctor
    {
        this.set_direction(new Vector (other.get_direction()));
        this.set_POO(new Point3D(other.get_POO()));

    }
    public void set_direction(Vector _direction) {
        this._direction = _direction;
    }

    public void set_POO(Point3D _POO) {
        this._POO = _POO;
    }

    public Vector get_direction() {
        return _direction;
    }

    public Point3D get_POO() {
        return _POO;
    }

    @Override
    public String toString() {
        return "Ray{" + "_POO= " + _POO + ", _direction=" + _direction + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Ray)) return false;
        Ray ray = (Ray) o;
        return _POO.equals(ray._POO) &&
                _direction.equals(ray._direction);
    }

}
