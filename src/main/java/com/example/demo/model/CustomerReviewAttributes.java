package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class  CustomerReviewAttributes{

    @JsonProperty("rating")
    private int rating;

    @JsonProperty("title")
    private String title;

    @JsonProperty("reviewerNickname")
    private String reviewerNickname;

    @JsonProperty("createdDate")
    private String createdDate;

    @JsonProperty("body")
    private String body;

    @JsonProperty("territory")
    private String territory;

    @Override
    public String toString() {
        return "CustomerReviewAttributes{" +
                "rating=" + rating +
                ", title='" + title + '\'' +
                ", reviewerNickname='" + reviewerNickname + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", body='" + body + '\'' +
                ", territory='" + territory + '\'' +
                '}';
    }
}
