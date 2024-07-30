package com.example.demo.Controller;



import com.example.demo.mapper.ReviewMapper;
import com.example.demo.model.CustomerReviewAttributes;
import com.example.demo.model.Feed;
import com.example.demo.model.Review;
import com.example.demo.service.JsonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReviewFileUploadController {

    @Autowired
    JsonService jsonService;

    @PostMapping("/upload-reviews")
    public ResponseEntity<List<Review>> uploadReviews(@RequestParam("file") MultipartFile file) {
        try {
            String jsonContent = new String(file.getBytes());
            List<Review> reviewList = jsonService.readJsonStringToReviewList(jsonContent);
            return ResponseEntity.ok(reviewList);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}