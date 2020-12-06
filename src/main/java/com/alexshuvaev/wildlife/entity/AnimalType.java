package com.alexshuvaev.wildlife.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "animal_type")
public class AnimalType extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "animal_class")
    private AnimalClass animalClass;

    @Enumerated(EnumType.STRING)
    @Column(name = "populations_group")
    private PopulationsGroup populationsGroup;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animalType", fetch = FetchType.LAZY)
    List<Animal> animals;
}
