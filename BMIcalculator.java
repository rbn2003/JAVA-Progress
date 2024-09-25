//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BMIcalculator{
    public static void main(String[] args) {

        double height = 1.80; // height in meters
        double weight = 170.0; // height in lbs

        double bmi = weight / (height * height);

        System.out.printf("BMI: %.2f\n", bmi); // calculating bmi
    }
}