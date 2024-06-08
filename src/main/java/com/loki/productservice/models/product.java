package com.loki.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class product extends BaseModel {

    private String title;
    private String description;
    private double price;
    private String imageURL;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Category category;
}
