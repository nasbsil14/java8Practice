package section1;

import common.BeforeAfterPractice;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * 20以上の数値を合算して10%引く
 */
public class Practice1 implements BeforeAfterPractice {
    final List<BigDecimal> prices = Arrays.asList(
            new BigDecimal("10"), new BigDecimal("30"), new BigDecimal("17"),
            new BigDecimal("20"), new BigDecimal("15"), new BigDecimal("18"),
            new BigDecimal("45"), new BigDecimal("12")
    );

    @Override
    public void before() {
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal price: prices) {
            if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
                total = total.add(price.multiply(BigDecimal.valueOf(0.9)));
            }
        }
        System.out.println(total);
    }

    @Override
    public void after() {
        final BigDecimal total =
                prices.stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.9)))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(total);
    }
}
