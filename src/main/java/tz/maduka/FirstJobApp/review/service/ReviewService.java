package tz.maduka.FirstJobApp.review.service;

import org.springframework.http.ResponseEntity;
import tz.maduka.FirstJobApp.review.model.Review;

import java.util.List;

public interface ReviewService {

   List<Review> getAllReviews(Long companyId);
}
