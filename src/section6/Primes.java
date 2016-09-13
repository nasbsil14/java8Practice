package section6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Primes {
    private static int primeAfter(final int number) {
        if (isPrime(number + 1)) {
            return number + 1;
        } else {
            return primeAfter(number + 1);
        }
    }

    public static List<Integer> primes(final int fromNumber, final int count) {
        //無限リストの生成
        return Stream.iterate(primeAfter(fromNumber - 1), Primes::primeAfter)
                .limit(count)
                .collect(Collectors.<Integer>toList());
    }

    /*
      引数が1より大きく、また2とその数の平方根の間の数で割り切れない場合、素数(True)
     */
    public static boolean isPrime(final int number) {
        //rangeCloseは第２引数を含む範囲、rangeは第2引数を含まない範囲の数値を返す
        //noneMatchはストリームコレクションから渡された値全てが条件にマッチしない場合にTrue(以下の場合除数がなければTrue)
        return number > 1 &&
                IntStream.rangeClosed(2, (int)Math.sqrt(number))
                .noneMatch(divisor -> number % divisor == 0);
    }
}
