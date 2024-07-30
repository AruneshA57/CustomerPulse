package com.example.demo.service;

import com.example.demo.model.Review;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonService {

    public List<Review> readJsonStringToReviewList(String jsonContent) {
        Gson gson = new Gson();
        JsonObject jsonObject = JsonParser.parseString(jsonContent).getAsJsonObject();
        List<Review> reviewList = new ArrayList<>();

        JsonArray entries = jsonObject.getAsJsonObject("feed")
                .getAsJsonArray("entry");

        for (JsonElement entryElement : entries) {
            JsonObject entry = entryElement.getAsJsonObject();

            String authorName = entry.getAsJsonObject("author")
                    .getAsJsonObject("name")
                    .get("label")
                    .getAsString();

            String updated = entry.getAsJsonObject("updated")
                    .get("label")
                    .getAsString();

            String title = entry.getAsJsonObject("title")
                    .get("label")
                    .getAsString();

            String content = entry.getAsJsonObject("content")
                    .get("label")
                    .getAsString();

            Review review = new Review(authorName, updated, title, content);
            reviewList.add(review);
        }

        return reviewList;
    }


}