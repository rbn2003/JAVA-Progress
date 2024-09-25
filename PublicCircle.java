public class PublicCircle {
    public double radius; // Public instance variable. This can be read or changed from anywhere!
// Constructor method. This is what we call to get new instances of

    public PublicCircle(double initRadius) {
        radius = initRadius;
    }

    // Instance method to compute area.
    public double area() {
        return 3.14 * radius * radius; // pi * r^2, the formula for computing a circle's area from radius.
    }
// TODO: write instance method to compute circumference.

    public double circumference() {
        return 3.14 * 2 * radius; // 2*pie*r, the formula for computing a circle's circumference from radius.
    }
}
