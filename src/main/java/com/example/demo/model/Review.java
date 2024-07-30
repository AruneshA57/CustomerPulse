package com.example.demo.model;

import lombok.Data;

@Data
public class Review {
    String authorName;
    String updated;
    String title;
    String content;

    @Override
    public String toString() {
        return "Review{" +
                "authorName='" + authorName + '\'' +
                ", updated='" + updated + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Review(String authorName, String updated, String title, String content) {
        this.authorName = authorName;
        this.updated = updated;
        this.title = title;
        this.content = content;
    }
}
