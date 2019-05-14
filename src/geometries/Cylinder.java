package geometries;
        import java.util.List;

        import primitives.Point3D;
        import primitives.Ray;
        import primitives.Vector;
        import java.awt.Color;

public class Cylinder extends RadialGeometry
{
    Point3D _axisPoint;
    Vector _axisDirection;

    public Point3D get_axisPoint() {
        return _axisPoint;
    }

    public void set_axisPoint(Point3D _axisPoint) {
        this._axisPoint = _axisPoint;
    }

    public Vector getAxisDirection() {
        return _axisDirection;
    }

    public void setAxisDirection(Vector axisDirection) {
        this._axisDirection = axisDirection;
    }

    public Cylinder()
    {
        super();
        _axisPoint = new Point3D();
        _axisDirection = new Vector();
    }

    public Cylinder(Cylinder cylinder)
    {
        super(cylinder._radius);
        _axisPoint = cylinder.get_axisPoint();
        _axisDirection = cylinder.getAxisDirection();
    }

    public Cylinder(double radius, Point3D axisPoint, Vector axisDirection )
    {
        super(radius);
        _axisPoint = new Point3D(axisPoint);
        _axisDirection = new Vector(axisDirection);
    }


    public String toString() {
        return "Cylinder [axisPoint=" + this.get_axisPoint() + ", axisDirection=" + this.getAxisDirection() + "]";
    }

    @Override
    public Vector getNormal(Point3D point)
    {
        point.subtract(this.get_axisPoint());
        Vector v = new Vector(point);
        v.normalize();
        return v;
    }
}





