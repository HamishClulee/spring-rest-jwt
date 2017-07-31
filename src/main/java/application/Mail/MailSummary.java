package application.Mail;

import java.util.Date;

/**
 * Created by hamish on 31/07/17.
 */
public class MailSummary {

    private Date date;
    private String subject;
    private String bodySummary;
    private Boolean isRead;
    private String userId;

    public MailSummary(){}

    public MailSummary(final Date date, final String subject, final String bodySummary, final Boolean isRead, final String userId){
        this.date = date;
        this.subject = subject;
        this.bodySummary = bodySummary;
        this.isRead = isRead;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBodySummary() {
        return bodySummary;
    }

    public void setBodySummary(String bodySummary) {
        this.bodySummary = bodySummary;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MailSummary that = (MailSummary) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (bodySummary != null ? !bodySummary.equals(that.bodySummary) : that.bodySummary != null) return false;
        if (isRead != null ? !isRead.equals(that.isRead) : that.isRead != null) return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (bodySummary != null ? bodySummary.hashCode() : 0);
        result = 31 * result + (isRead != null ? isRead.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MailSummary{" +
                "date=" + date +
                ", subject='" + subject + '\'' +
                ", bodySummary='" + bodySummary + '\'' +
                ", isRead=" + isRead +
                ", userId='" + userId + '\'' +
                '}';
    }
}
