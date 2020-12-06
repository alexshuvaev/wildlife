package com.alexshuvaev.wildlife.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="territory")
public class Territory  extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "area_code")
    private String areaCode;

    @Column(name = "square")
    private BigDecimal square;

    @Column(name = "person")
    private String person;

    @Column(name = "phone")
    private String phone;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "territory", fetch = FetchType.LAZY)
    List<Animal> animals;
}
