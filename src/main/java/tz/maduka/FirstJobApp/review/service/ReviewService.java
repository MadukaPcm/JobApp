package tz.maduka.FirstJobApp.review.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tz.maduka.FirstJobApp.review.model.Review;
import tz.maduka.FirstJobApp.review.payload.rest.ReviewDto;

import java.util.List;

public interface ReviewService {

   List<Review> getAllReviews(Long companyId);
   boolean addReview(Long companyId, ReviewDto reviewDto);
   Review getReview(Long companyId, Long reviewId);
   boolean updateReview(Long companyId, Long reviewId,ReviewDto reviewDto );
   boolean deleteReview(Long companyId, Long reviewId);
}
