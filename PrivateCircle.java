public class PrivateCircle {

        private double radius; // private instance variable. As explained on pg. 208 ofthe text,
        // this means that this instance variable "cannot be accessed by name outside of the class definition!"
// Constructor method. This is what we call to get new instances of

        public PrivateCircle(double initRadius) {
            radius = initRadius;
        }
        // Instance method to compute area.
        public double area() {
            return 3.14 * radius * radius; // pi * r^2, the formula for computing a circle's area from radius.
        }

        // getter of the radius
        public double getRadius( ) {
            return radius;
        }

        //setter of the radius
        public void setRadius(double newRadius) {
            radius = newRadius;
        }
// TODO: write instance method to compute circumference.



// TODO: write setter and getter methods for the radius.
    }


