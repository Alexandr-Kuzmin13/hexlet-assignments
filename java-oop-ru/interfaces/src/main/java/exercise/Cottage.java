package exercise;

// BEGIN
class Cottage implements Home {
    private final double area;
    private final int floorCount;

    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    public String toString() {
        return floorCount + " этажный коттедж площадью " + area + " метров";
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home home) {
        if (this.getArea() > home.getArea()) {
            return 1;
        } else if (this.getArea() < home.getArea()) {
            return - 1;
        }
        return 0;
    }
}
// END
