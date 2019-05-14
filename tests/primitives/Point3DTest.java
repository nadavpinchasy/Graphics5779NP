package primitives;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Point3DTest {

    @Test
    void distance() {
        Point3D p1 = new Point3D(1,2,3);
        Point3D p2 = new Point3D(3,4,5);

        double result =3.4641;
        assertEquals(result,p1.distance(p2),0.00001);
    }
}