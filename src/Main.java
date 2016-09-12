import common.BeforeAfterPractice;
import common.TargetPractice;

public class Main {
    public static void main(String[] args) {
        System.out.println("START");

        //hello、ラムダ式
        System.out.println("######## section1 ##########");
        final BeforeAfterPractice target1 = new section1.Practice1();
        target1.run();

        //コレクションの使用
        System.out.println("######## section2 ##########");
        final BeforeAfterPractice target2 = new section2.Practice1();
        target2.run();

        //ラムダ式で設計する
        System.out.println("######## section4 ##########");
        final TargetPractice target3 = new section4.Practice1();
        target3.run();
        final TargetPractice target3_2 = new section4.Practice2();
        target3_2.run();

        //外部リソースを扱う
        System.out.println("######## section5 ##########");
        final TargetPractice target4 = new section5.Practice1();
        target4.run();

        //「遅延させる」ということ
        System.out.println("######## section6 ##########");
        final TargetPractice target5 = new section6.Practice1();
        target5.run();

        System.out.println("END");
    }
}
