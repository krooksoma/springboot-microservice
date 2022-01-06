package com.defaria.springbootmicroservice.services;

import com.defaria.springbootmicroservice.domain.Difficulty;
import com.defaria.springbootmicroservice.domain.Region;
import com.defaria.springbootmicroservice.domain.Tour;
import com.defaria.springbootmicroservice.domain.TourPackage;
import com.defaria.springbootmicroservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired

    public TourService(TourRepository tourRepository,
                       TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description,
                           String blurb, BigDecimal price, String duration,
                           String bullets, String keywords, String tourPackageName,
                           Difficulty difficulty, Region region){

        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName)
                .orElseThrow(()-> new RuntimeException("Tour package not found. Tour Package name: " + tourPackageName));

        return tourRepository.save(new Tour(title, description, blurb, price, duration,
                bullets, keywords, tourPackage, difficulty, region));
    }

    public long total(){
        return tourRepository.count();
    }
}
