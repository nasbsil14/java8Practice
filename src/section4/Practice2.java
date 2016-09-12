package section4;

import common.BeforeAfterPractice;
import section4.mail.FluentMailer;
import section4.mail.MailBuilder;
import section4.mail.Mailer;

/*
 case 1 単純な構成
 case 2 メソッドチェーンできるようにした
 case 3 内容の設定のみを行えるようにし、前処理・送信処理などは切り離した（ローンパターン）
 */
public class Practice2 implements BeforeAfterPractice {

    @Override
    public void before() {
        //case 1
        Mailer mailer = new Mailer();
        mailer.from("");
        mailer.to("");
        mailer.subject("");
        mailer.body("");
        mailer.send();

        //case 2
        MailBuilder mailBuilder = new MailBuilder();
        mailBuilder.from("").to("").subject("").body("").send();
    }

    @Override
    public void after() {
        // case 3
        FluentMailer.send(mailer ->
                mailer.from("")
                        .to("")
                        .subject("")
                        .body(""));
    }
}
