package com.defaria.springbootmicroservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


@Document
@Setter
@Getter
public class TourRating {

   @Id
    private String id;

   private String tourId;

   @NotNull
    private Integer customerId;

   @Min(0)
   @Max(5)
   private Integer score;

   @Size(max = 250)
   private String comment;

    public TourRating(String tourId, Integer customerId, Integer score, String comment) {
        this.tourId = tourId;
        this.customerId = customerId;
        this.score = score;
        this.comment = comment;
    }

    protected TourRating(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRating that = (TourRating) o;
        return Objects.equals(id, that.id) && Objects.equals(tourId, that.tourId) && Objects.equals(customerId, that.customerId) && Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tourId, customerId, score);
    }

    @Override
    public String toString() {
        return "TourRating{" +
                "id='" + id + '\'' +
                ", tourId='" + tourId + '\'' +
                ", customerId=" + customerId +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }
}
