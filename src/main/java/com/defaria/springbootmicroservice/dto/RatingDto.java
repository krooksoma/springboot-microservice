package com.defaria.springbootmicroservice.dto;

import com.defaria.springbootmicroservice.domain.TourRating;
import lombok.Getter;
import lombok.Setter;
import org.yaml.snakeyaml.constructor.Construct;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class RatingDto {

    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    //Construct a RatingDto from a fully instantiated TourRating

    public RatingDto(TourRating tourRating){
        this(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
    }

    public RatingDto(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    protected RatingDto(){}


}
