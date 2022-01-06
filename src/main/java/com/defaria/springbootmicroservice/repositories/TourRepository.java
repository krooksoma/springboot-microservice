package com.defaria.springbootmicroservice.repositories;

import com.defaria.springbootmicroservice.domain.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, String> {
}
