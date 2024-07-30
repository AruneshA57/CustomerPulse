package com.example.demo.mapper;

import com.example.demo.model.CustomerReviewAttributes;
import com.example.demo.model.Feed;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewMapper {

    public List<CustomerReviewAttributes> mapJsonToReviews(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Feed feed = objectMapper.readValue(json, Feed.class);
        feed = feed;
        return feed.getEntry().stream().map(entry -> {
            CustomerReviewAttributes review = new CustomerReviewAttributes();
            review.setRating(Integer.parseInt(entry.getRating().getLabel()));
            review.setTitle(entry.getTitle().getLabel());
            review.setReviewerNickname(entry.getAuthor().getName().getLabel());
            review.setCreatedDate(entry.getUpdated().getLabel());
            review.setBody(entry.getContent().getLabel());
            // Assuming 'territory' is not directly available in the JSON, set it to null or a default value
            review.setTerritory(null);
            return review;
        }).collect(Collectors.toList());
    }
}