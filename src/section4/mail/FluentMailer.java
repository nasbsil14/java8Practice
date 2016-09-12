package section4.mail;

import java.util.function.Consumer;

/*
  必要最低限をこちらで用意しているから、使うことになったらお越しくださいパターン
  電話ボックス的な・・・
 */
public class FluentMailer {
    private Mailer baseMailer;
    //インスタンス化不可
    private FluentMailer() {
        baseMailer = new Mailer();
    }

    /*
      以下メソッドはpublicであるが、
       1.インスタンス化不可
       2.sendメソッドを高階関数化
      することによりスコープ局所化（sendメソッド引数の関数内のみ)
     */
    public FluentMailer from(final String address) {baseMailer.from(address); return this;}
    public FluentMailer to(final String address) {baseMailer.to(address); return this;}
    public FluentMailer subject(final String line) {baseMailer.subject(line); return this;}
    public FluentMailer body(final String message) {baseMailer.body(message); return this;}

    public static void send(final Consumer<FluentMailer> block) {
        final FluentMailer mailer = new FluentMailer();
        block.accept(mailer);
        System.out.println("send using lease mailer object");
        mailer.baseMailer.send();
    }
}
