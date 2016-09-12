package section4.mail;

public class Mailer {
    private String fromAddress;
    private String toAddress;
    private String subjectLine;
    private String bodyMessage;

    public void from(final String address) {this.fromAddress = address;}
    public void to(final String address) {this.toAddress = address;}
    public void subject(final String line) {this.subjectLine = line;}
    public void body(final String message) {this.bodyMessage = message;}
    public void send() {
        System.out.println("mail send");
    }
}
