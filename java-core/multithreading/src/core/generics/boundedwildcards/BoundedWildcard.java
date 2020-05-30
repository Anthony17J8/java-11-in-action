package core.generics.boundedwildcards;

public class BoundedWildcard {

    static void showXY(Coords<?> c) {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        }
        System.out.println();
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(
                            c.coords[i].x + " " +
                            c.coords[i].y + " " +
                            c.coords[i].z);
        }
        System.out.println();
    }

    static void showAll(Coords<? extends FourD> c) {
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(
                            c.coords[i].x + " " +
                            c.coords[i].y + " " +
                            c.coords[i].z + " " +
                            c.coords[i].t);
        }
    }

    public static void main(String[] args) {
        TwoD[] twoD = {
                new TwoD(0, 0),
                new TwoD(1, 9),
                new TwoD(-12, 4),
                new TwoD(2, 0)
        };

        Coords<TwoD> tdCoords = new Coords<>(twoD);
        System.out.println("Contents of tdCoords: ");
        showXY(tdCoords);
    //  showXYZ(tdCoords);   not a ThreeD
    //  showAll(tdCoords);   not a FourD

        FourD[] fourD = {
                new FourD(1, 2, 6, -2),
                new FourD(-2, 5, 9, 11)
        };

        Coords<FourD> fdCoords = new Coords<>(fourD);
        System.out.println("Contents of fdCoords: ");
        showXY(fdCoords);
        showXYZ(fdCoords);
        showAll(fdCoords);
    }
}

class TwoD {
    int x, y;

    public TwoD(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class ThreeD extends TwoD {
    int z;

    public ThreeD(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}

class FourD extends ThreeD {
    int t;

    public FourD(int x, int y, int z, int t) {
        super(x, y, z);
        this.t = t;
    }
}

class Coords<T extends TwoD> {
    T[] coords;

    public Coords(T[] coords) {
        this.coords = coords;
    }
}
