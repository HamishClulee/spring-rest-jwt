package application.Mail;

import application.Utils.Utils;
import org.mongodb.morphia.annotations.Id;

import java.util.UUID;

/**
 * Created by hamish on 31/07/17.
 */
public class Mail {

    @Id
    private UUID id;
    private MailSummary mailSummary;
    private String longBody;

    public Mail(final UUID id, final MailSummary mailSummary, final String longBody){
        this.id = id;
        this.mailSummary = mailSummary;
        this.longBody = longBody;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

        if (id != null ? !id.equals(mail.id) : mail.id != null) return false;
        if (mailSummary != null ? !mailSummary.equals(mail.mailSummary) : mail.mailSummary != null) return false;
        return longBody != null ? longBody.equals(mail.longBody) : mail.longBody == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mailSummary != null ? mailSummary.hashCode() : 0);
        result = 31 * result + (longBody != null ? longBody.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "id=" + id +
                ", mailSummary=" + mailSummary +
                ", longBody='" + longBody + '\'' +
                '}';
    }
}
