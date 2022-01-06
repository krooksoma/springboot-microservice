package com.defaria.springbootmicroservice.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Setter
@Getter
public class TourPackage{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String code;

    @Column
    private String name;


    public TourPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public TourPackage() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TourPackage that = (TourPackage) o;
        return code != null && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
