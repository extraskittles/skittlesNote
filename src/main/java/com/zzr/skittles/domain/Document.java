package com.zzr.skittles.domain;

public class Document {
    private Integer id;

    private String title;

    private String html;

    public Document(Integer id, String title, String html) {
        this.id = id;
        this.title = title;
        this.html = html;
    }

    public Document() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html == null ? null : html.trim();
    }
}