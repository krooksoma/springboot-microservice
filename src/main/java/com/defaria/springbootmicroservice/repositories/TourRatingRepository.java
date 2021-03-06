package com.defaria.springbootmicroservice.repositories;

import com.defaria.springbootmicroservice.domain.TourRating;
import com.defaria.springbootmicroservice.domain.TourRatingPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

//does not expose the data
@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {

    Page<TourRating> findByTourId(String tourId, Pageable pageable);

    List<TourRating> findByTourId(String tourId);

    Optional<TourRating> findByTourIdAndCustomerId(String tourId, Integer customerId);
}
