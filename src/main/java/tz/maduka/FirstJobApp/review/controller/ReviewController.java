package tz.maduka.FirstJobApp.review.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tz.maduka.FirstJobApp.review.model.Review;
import tz.maduka.FirstJobApp.review.payload.rest.ReviewDto;
import tz.maduka.FirstJobApp.review.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllREviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody ReviewDto reviewDto){
      boolean success = reviewService.addReview(companyId, reviewDto);
      if (success){
          return new ResponseEntity<>("Review added successfully !!", HttpStatus.OK);
      }else {
          return new ResponseEntity<>("Failed to create review !!",HttpStatus.BAD_REQUEST);
      }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody ReviewDto reviewDto){
        boolean isReviewUpdated = reviewService.updateReview(companyId, reviewId, reviewDto);
        if(isReviewUpdated){
            return new ResponseEntity<>("Review updated successfully !!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review update failed !!", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview(companyId, reviewId);
        if(isReviewDeleted){
            return new ResponseEntity<>("Review deleted successfully !!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review delete failed !!", HttpStatus.NOT_FOUND);
    }
}
