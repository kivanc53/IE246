package recitations.rec1;


/*
    Find the prime numbers in range 1-100 (both inclusive) and print them
    Not: Bir sayı karekökünden küçük olan asal sayıların hiçbirisine bölünmüyorsa asaldır
 */
public class Problem9 {
    public static void main(String[] args) {
        problem9();
    }

    public static void problem9() {
        for (int i = 1; i <= 100; i++)
            if (isPrime(i))
                System.out.print(i + " ");
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

