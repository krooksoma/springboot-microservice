package com.defaria.springbootmicroservice.services;

import com.defaria.springbootmicroservice.domain.Tour;
import com.defaria.springbootmicroservice.domain.TourPackage;
import com.defaria.springbootmicroservice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new Tour Object and persist it to the Database
     *
     * @param title Title of the tour
     * @param tourPackageName tour Package of the tour
     * @param details Extra details about the tour
     * @return Tour
     */
    public Tour createTour(String title, String tourPackageName, Map<String, String> details) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(() ->
                new RuntimeException("Tour package does not exist: " + tourPackageName));
        return tourRepository.save(new Tour(title, tourPackage, details));
    }
    /**
     * Calculate the number of Tours in the Database.
     *
     * @return the total.
     */
    public long total() {
        return tourRepository.count();
    }
}

