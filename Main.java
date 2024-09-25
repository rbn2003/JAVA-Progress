public class Main {
    public static void main(String[] args) {

        int totalSeconds = 50391; // given time
        int hours = totalSeconds/3600; // calculating to hours
        int remainder = totalSeconds % 3600; // saving the remaining seconds

        int minutes = remainder / 60; // calculating to the minutes
        int seconds = remainder % 60; //remaining seconds after calculating to minutes

        System.out.println("The corresponding time is" + hours + "hours," + minutes + "minutes, and" + seconds + "seconds.");


    }
}