package application.Mail;

import org.mongodb.morphia.annotations.Id;

/**
 * Created by hamish on 31/07/17.
 */
public class Mail {

    @Id
    private String uuid;
    private String userId;
    private MailSummary mailSummary;
    private String longBody;
    private Boolean read;

    public Mail() {}

    public Mail(final String uuid, final String userId, final MailSummary mailSummary, final String longBody, final Boolean read){
        this.uuid = uuid;
        this.userId = userId;
        this.mailSummary = mailSummary;
        this.longBody = longBody;
        this.read = read;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public MailSummary getMailSummary() {
        return mailSummary;
    }

    public void setMailSummary(MailSummary mailSummary) {
        this.mailSummary = mailSummary;
    }

    public String getLongBody() {
        return longBody;
    }

    public void setLongBody(String longBody) {
        this.longBody = longBody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mail mail = (Mail) o;

        if (uuid != null ? !uuid.equals(mail.uuid) : mail.uuid != null) return false;
        if (userId != null ? !userId.equals(mail.userId) : mail.userId != null) return false;
        if (mailSummary != null ? !mailSummary.equals(mail.mailSummary) : mail.mailSummary != null) return false;
        if (longBody != null ? !longBody.equals(mail.longBody) : mail.longBody != null) return false;
        return read != null ? read.equals(mail.read) : mail.read == null;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (mailSummary != null ? mailSummary.hashCode() : 0);
        result = 31 * result + (longBody != null ? longBody.hashCode() : 0);
        result = 31 * result + (read != null ? read.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "uuid='" + uuid + '\'' +
                ", userId='" + userId + '\'' +
                ", mailSummary=" + mailSummary +
                ", longBody='" + longBody + '\'' +
                ", read=" + read +
                '}';
    }
}
