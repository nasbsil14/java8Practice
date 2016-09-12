package section2;

import common.BeforeAfterPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * case1 リストをイテレートする
 * case2 リスト内文字列編集
 * case3 リストから検索した文字列を新しいリストに格納する
 * case4 関数の再利用
 */
public class Practice1 implements BeforeAfterPractice {
    final List<String> friends =
            Arrays.asList("Taro", "Jiro", "Saburo", "Siro", "Goro", "Rokuro", "Nanaro", "Hachiro");

    final List<String> friends2 =
            Arrays.asList("Tanaka", "Suzuki", "Simada", "Endo", "Murakami", "Nakamura", "Sasaki", "Inoue");
    final List<String> friends3 =
            Arrays.asList("Neko", "Inu", "Niwatori", "Suzume", "Tora", "Sika", "Saru");

    @Override
    public void before() {
        beforCase1();
        beforCase2();
        beforCase3();

    }

    @Override
    public void after() {
        afterCase1();
        afterCase2();
        afterCase3();
    }

    private void beforCase1() {
        for (String name: friends) {
            System.out.println(name);
        }
    }
    private void afterCase1() {
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });

        //さらに簡潔に
        friends.forEach((final String s) -> System.out.println(s));

        //さらに
        friends.forEach(System.out::println);
    }
    private void beforCase3() {
        final List<String> startWithS = new ArrayList<String>();
        for (String name: friends) {
            if (name.startsWith("S")) {
                startWithS.add(name);
            }
        }
    }
    private void beforCase4() {
        final long contStartS = friends.stream().filter(name -> name.startsWith("S")).count();
        final long contStartS2 = friends2.stream().filter(name -> name.startsWith("S")).count();
        final long contStartS3 = friends3.stream().filter(name -> name.startsWith("N")).count();
    }


    private void beforCase2() {
        final List<String> upperNames = new ArrayList<String>();
        for (String name: friends) {
            upperNames.add(name.toUpperCase());
        }
    }
    private void afterCase2() {
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);
    }
    private void afterCase3() {
        final List<String> startWithS =
            friends.stream()
                    .filter(name -> name.startsWith("S"))
                    .collect(Collectors.toList());
    }
    private void afterCase4() {
        //関数を返すstaticメソッドを使用した場合
        final long contStartS = friends.stream().filter(checkStartWith("S")).count();
        final long contStartS2 = friends2.stream().filter(checkStartWith("S")).count();
        final long contStartS3 = friends3.stream().filter(checkStartWith("N")).count();

        //制限されたスコープ内で関数を再利用する場合
        final Function<String, Predicate<String>> startWithLetter =
                (String letter) -> {
                    Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
                    return checkStarts;
                };
        final long contStartS_v2 = friends.stream().filter(checkStartWith("S")).count();
        final long contStartS2_v2 = friends2.stream().filter(checkStartWith("S")).count();
        final long contStartS3_v2 = friends3.stream().filter(checkStartWith("N")).count();
    }
    private static Predicate<String> checkStartWith(final String letter) {
        return name -> name.startsWith(letter);
    }
}
