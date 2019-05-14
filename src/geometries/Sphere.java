package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.awt.Color;

public class Sphere extends RadialGeometry {
    protected Point3D _center;

    public void set_center(Point3D _center) {
        this._center = _center;
    }

    public Point3D get_center() {
        return _center;
    }

    public Sphere(Point3D center, double radius) {
        super(radius);
        _center = center;
    }

    public Sphere(Sphere other) {
        super(other.get_radius());
        _center = other.get_center();
    }
    public Sphere() {
        super();
        _center = Point3D.ZERO;
    }

    @Override
    public Vector getNormal(Point3D point) {
        Vector normal = new Vector(_center, point);
        normal.normalize();
        return normal;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!(other instanceof Sphere)) return false;
        Sphere sphere = (Sphere) other;
        return (this.get_center()).equals(sphere.get_center());
    }

    @Override
    public String toString() {
        return "Sphere{" + "center=" + get_center() + '}';
    }

}
