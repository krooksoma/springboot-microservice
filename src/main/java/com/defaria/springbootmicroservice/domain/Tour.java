package com.defaria.springbootmicroservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;
import java.util.Objects;


@Getter
@Setter
@Document
public class Tour {

    @Id
    private String id;

    @Indexed
    private String title;

    @Indexed
    private String tourPackageCode;

    private String tourPackageName;

    private Map<String, String> details;

    public Tour(String title, TourPackage tourPackage, Map<String, String> details){
        this.title = title;
        this.tourPackageCode = tourPackage.getCode();
        this.tourPackageName = tourPackage.getName();
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) && Objects.equals(title, tour.title) && Objects.equals(tourPackageCode, tour.tourPackageCode) && Objects.equals(tourPackageName, tour.tourPackageName) && Objects.equals(details, tour.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, tourPackageCode, tourPackageName, details);
    }
}
