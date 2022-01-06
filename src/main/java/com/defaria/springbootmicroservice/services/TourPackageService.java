package com.defaria.springbootmicroservice.services;

import com.defaria.springbootmicroservice.domain.TourPackage;
import com.defaria.springbootmicroservice.repositories.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TourPackageService {

    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(String code, String name){

        //search for an existing tour package, if not present it returns a new one
        return tourPackageRepository.findById(code).
                orElse(tourPackageRepository.save(new TourPackage(code, name)));
    }

    //look up all tour packages
    public Iterable<TourPackage> lookUp(){

        return tourPackageRepository.findAll();
    }

    //get total number of tour packages
    public long total(){ return tourPackageRepository.count(); }
}
