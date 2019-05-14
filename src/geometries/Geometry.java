package geometries;

import java.awt.Color;
import primitives.Point3D;
import primitives.Vector;
import primitives.Ray;
import java.util.List;

public  interface  Geometry
{
   //public abstract List<Point3D> findIntersections(Ray ray);

    public abstract Vector getNormal(Point3D point);

}
