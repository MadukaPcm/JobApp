package tz.maduka.FirstJobApp.review.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tz.maduka.FirstJobApp.review.model.Review;
import tz.maduka.FirstJobApp.review.repository.ReviewRepository;
import tz.maduka.FirstJobApp.review.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }
}
