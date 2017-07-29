package application.mail;

import java.util.Date;

/**
 * Created by hamish on 27/07/17.
 */
public class Mail {

    String userid;
    String subject;
    Date date;
    String messageBody;
    String type;

    public Mail() {}

    public Mail(String userid, String subject, Date date, String messageBody, String type) {
        this.userid = userid;
        this.subject = subject;
        this.date = date;
        this.messageBody = messageBody;
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mail mail = (Mail) o;

        if (userid != null ? !userid.equals(mail.userid) : mail.userid != null) return false;
        if (subject != null ? !subject.equals(mail.subject) : mail.subject != null) return false;
        if (date != null ? !date.equals(mail.date) : mail.date != null) return false;
        if (messageBody != null ? !messageBody.equals(mail.messageBody) : mail.messageBody != null) return false;
        return type != null ? type.equals(mail.type) : mail.type == null;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (messageBody != null ? messageBody.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "userid='" + userid + '\'' +
                ", subject='" + subject + '\'' +
                ", date=" + date +
                ", messageBody='" + messageBody + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
