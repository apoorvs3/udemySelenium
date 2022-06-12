package updates;

import javax.mail.MessagingException;

public class javamails {
    public static void main(String[] args) throws MessagingException {
        MonitoringMail mail = new MonitoringMail();
        mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody);

    }
}
