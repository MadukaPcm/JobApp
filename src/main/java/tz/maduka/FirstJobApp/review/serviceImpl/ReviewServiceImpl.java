package tz.maduka.FirstJobApp.review.serviceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tz.maduka.FirstJobApp.company.model.Company;
import tz.maduka.FirstJobApp.company.payload.rest.dto.CompanyDto;
import tz.maduka.FirstJobApp.company.service.CompanyService;
import tz.maduka.FirstJobApp.review.model.Review;
import tz.maduka.FirstJobApp.review.payload.rest.ReviewDto;
import tz.maduka.FirstJobApp.review.repository.ReviewRepository;
import tz.maduka.FirstJobApp.review.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, ReviewDto reviewDto) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null){
            Review review = new Review();
            System.out.println(reviewDto.getTitle() +"  ====> "+reviewDto.getDescription()+"=============>>");
            review.setTitle(reviewDto.getTitle());
            review.setDescription(reviewDto.getDescription());
            review.setCompany(company);
            review.setRating(reviewDto.getRating());
            System.out.println("Saving review: " + review); // Debug log
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, ReviewDto reviewDto) {
        if(companyService.getCompanyById(companyId) != null){
            System.out.println("companyId: " + companyId);
            System.out.println("reviewId: " + reviewId);
            System.out.println("ReviewDto: " + reviewDto);

            Review review = new Review();
            review.setId(reviewId);
            review.setTitle(reviewDto.getTitle());
            review.setDescription(reviewDto.getDescription());
            review.setRating(reviewDto.getRating());
            review.setCompany(companyService.getCompanyById(companyId));
            reviewRepository.save(review);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();

            CompanyDto companyDto = new CompanyDto();
            companyDto.setName(company.getName());
            companyDto.setDescription(company.getDescription());

            company.getReviews().remove(review);
            review.setCompany(null);
            companyService.updateCompany(companyDto,companyId);
            reviewRepository.deleteById(reviewId);
            return true;
        }else{
            return false;
        }
    }

}
