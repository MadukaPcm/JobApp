package tz.maduka.FirstJobApp.review.payload.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

    //    private Long id;
    private String title;
    private String description;
    private double rating;
}
