package hackerrank.medium;

import java.math.BigInteger;

public class ExtraLong {

    public static void extraLongFactorials(int n) {

        BigInteger bigInteger = BigInteger.ONE;

        for(int i=1; i<=n; i++){

            //bigInteger * i
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));

        }
        System.out.println(bigInteger);
    }
}
