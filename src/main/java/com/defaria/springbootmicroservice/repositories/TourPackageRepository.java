package com.defaria.springbootmicroservice.repositories;

import com.defaria.springbootmicroservice.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

    Optional<TourPackage> findByName(String tourPackageName);
}
