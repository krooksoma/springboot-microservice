package com.defaria.springbootmicroservice.repositories;

import com.defaria.springbootmicroservice.domain.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, String> {
    Page<Tour> findByTourPackageCode(@Param("code") String code, Pageable pageable);

    @RestResource(exported = false)
    @Override
    <S extends Tour> S save(S entity);

    @RestResource(exported = false)
    @Override
    <S extends Tour> Iterable<S> saveAll(Iterable<S> entities);

    @RestResource(exported = false)
    @Override
    void deleteById(String string);

    @RestResource(exported = false)
    @Override
    void delete(Tour entity);

    @RestResource(exported = false)
    @Override
    void deleteAllById(Iterable<? extends String> strings);

    @RestResource(exported = false)
    @Override
    void deleteAll(Iterable<? extends Tour> entities);

    @RestResource(exported = false)
    @Override
    void deleteAll();

    @Query(value = "{'tourPackageCode' : ?0 }",
            fields = "{'id' : 1. 'title':1, 'tourPackageCode':1, 'tourPackageName':1}")
    Page<Tour> findSummaryByTourPackageCode(@Param("code") String code, Pageable pageable);
}
