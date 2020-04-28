package mina;

import java.io.Serializable;

/**
 * @author ：zht
 * @date ：Created in 2020/3/21 9:10
 * @description：
 * @modified By：
 * @version: $
 */
public class Message implements Serializable {
    private String form;
    private String to;
    private String type;
    private String info;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Message{" +
                "form='" + form + '\'' +
                ", to='" + to + '\'' +
                ", type='" + type + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
