package section6;

import java.util.function.Supplier;

/*
  「コンピューターサイエンスにおけるすべての問題は、関節処理を1レベル追加することにより解決できる」
 */
public class Holder {
    //ラムダによってHeavyを遅延生成（Holderインスタンス化時に「createAndCacheHeavy」が実行されるわけではない）
    private Supplier<Heavy> heavy = () -> createAndCacheHeavy();
    public Holder() {System.out.println("Holder created");}
    public Heavy getHeavy() {
        //関数の実行 = ここで初めてcreateAndCacheHeavyが実行される
        return heavy.get();
    }

    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {
            private final Heavy heavyInstance = new Heavy();

            @Override
            public Heavy get() {
                return heavyInstance;
            }
        }

        if (!HeavyFactory.class.isInstance(heavy)) {
            heavy = new HeavyFactory();
        }
        return heavy.get();
    }
}
