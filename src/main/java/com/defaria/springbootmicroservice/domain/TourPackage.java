package com.defaria.springbootmicroservice.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Objects;

@Document
@Setter
@Getter
public class TourPackage{

    @Id
    private String code;

    private String name;


    public TourPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public TourPackage() {
    }

    @Override
    public String toString() {
        return "TourPackage{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourPackage that = (TourPackage) o;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }
}
