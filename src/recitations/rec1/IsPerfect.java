package recitations.rec1;

public class IsPerfect {
    public static void main(String[] args) {
        System.out.println(isPerfect(28));
    }

    public static boolean isPerfect(int value) {
        int sum = 0;
        for (int i = 1; i <= value / 2; i++)
            if (value % i == 0)
                sum += i;
        return sum == value;
    }
}
