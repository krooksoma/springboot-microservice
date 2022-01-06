package com.defaria.springbootmicroservice.repositories;

import com.defaria.springbootmicroservice.domain.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

//changing endpoints
@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {

    Optional<TourPackage> findByName(String tourPackageName);

    //restricting access to endpoint
    @RestResource(exported = false)
    @Override
    <S extends TourPackage> S save(S entity);

    @RestResource(exported = false)
    @Override
    <S extends TourPackage> Iterable<S> saveAll(Iterable<S> entities);

    @RestResource(exported = false)
    @Override
    void deleteById(String s);

    @RestResource(exported = false)
    @Override
    void delete(TourPackage entity);

    @RestResource(exported = false)
    @Override
    void deleteAllById(Iterable<? extends String> strings);

    @RestResource(exported = false)
    @Override
    void deleteAll(Iterable<? extends TourPackage> entities);

    @RestResource(exported = false)
    @Override
    void deleteAll();
}
