package recitations.rec1;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(31));
    }
    public static boolean isPrime(int val) {
        if (val <= 1)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        int count = 0;

        for (int i = 11; i * i <= val; i += 2) {
            ++count;
            if (val % i == 0)
                return false;
        }

        return true;
    }
}
