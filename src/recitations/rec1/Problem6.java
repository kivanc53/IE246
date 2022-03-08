package recitations.rec1;


/*
    According to given height and weight information, calculate the bmi and specify which range it falls into:
		BMI < 18.5 --> underweight
		18.5 <= BMI < 24.9 --> Normal
		25 < BMI < 29.9 --> Overweight
		BMI >=30 --> Obese
 */
public class Problem6 {
    public static void main(String[] args) {
        int weight = 80;
        double height = 1.92;

        System.out.printf("person is %s", problem6(weight, height));
    }

    public static String problem6(int weight, double height) {
        double bmi = weight / Math.pow(height, 2);
        if (bmi < 18.5) {
            return "underweight";
        } else if (bmi < 24.9)
            return "normal";
        else if (bmi < 29.9)
            return "overweight";
        return "obese";
    }
}
