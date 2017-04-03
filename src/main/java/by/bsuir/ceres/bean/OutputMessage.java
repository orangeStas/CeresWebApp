package by.bsuir.ceres.bean;

import java.io.Serializable;

public class OutputMessage implements Serializable {
    private String from;
    private String text;
    private String time;
    private Long studentId;

    public OutputMessage(String from, String text, String time, Long studentId) {
        this.from = from;
        this.text = text;
        this.time = time;
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
