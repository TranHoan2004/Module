public interface MailService extends Constants.MailProperties {
    void sendEmail(String to, String subject, String body);
}
