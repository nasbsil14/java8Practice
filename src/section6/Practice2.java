package section6;

import common.BeforeAfterPractice;

import java.util.List;


public class Practice2 implements BeforeAfterPractice {

    @Override
    public void before() {
        //再帰によりStackOverflowになる処理
        try {
            System.out.println(primes(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void after() {
        //Streamの遅延を使って無限リストを扱う処理
        System.out.println(Primes.primes(1, 100));
        System.out.println(Primes.primes(100, 5));
    }

    private List<Integer> primes(final int number) {
        if (Primes.isPrime(number)) {
            return concat(number, primes(number + 1));
        } else {
            return primes(number + 1);
        }
    }
    private List<Integer> concat(final int number, List<Integer> numList) {
        return numList;
    }

    @Override
    public void run() {
        //before();
        after();
    }
}
