package section4.mail;

public class MailBuilder {
    private Mailer mailer;
    public MailBuilder() {
        mailer = new Mailer();
    }
    public MailBuilder from(final String address) {mailer.from(address); return this;}
    public MailBuilder to(final String address) {mailer.to(address); return this;}
    public MailBuilder subject(final String line) {mailer.subject(line); return this;}
    public MailBuilder body(final String message) {mailer.body(message); return this;}
    public void send() {
        System.out.println("builder send");
        mailer.send();
    }
}
