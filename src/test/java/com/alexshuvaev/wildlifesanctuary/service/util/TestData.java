package com.alexshuvaev.wildlifesanctuary.service.util;

import com.alexshuvaev.wildlife.entity.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public final class TestData {
    private TestData() {}

    // Territory
    public static final Territory territory1 = new Territory("Territory1", "areaCode1", new BigDecimal("100.50"), "Person1", "+312345", Collections.emptyList());
    public static final Territory territory2 = new Territory("Territory2", "areaCode2", new BigDecimal("150.50"), "Person2", "+354321", Collections.emptyList());
     static {
        territory1.setId(1);
        territory2.setId(2);
    }

    // AnimalType
    public static final AnimalType animalType1 = new AnimalType("animalType1", AnimalClass.AVES, PopulationsGroup.NORMAL, Collections.emptyList());
    public static final AnimalType animalType2 = new AnimalType("animalType2", AnimalClass.AVES, PopulationsGroup.NORMAL, Collections.emptyList());
    public static final AnimalType animalType3 = new AnimalType("animalType3", AnimalClass.AVES, PopulationsGroup.NORMAL, Collections.emptyList());
    static {
        animalType1.setId(1);
        animalType2.setId(2);
        animalType3.setId(3);
    }

    // Animal
    public static final Animal animal1 = new Animal(animalType1, territory1);
    public static final Animal animal2 = new Animal(animalType2, territory1);
    public static final Animal animal3 = new Animal(animalType3, territory1);
    public static final Animal animal4 = new Animal(animalType1, territory2);
    public static final Animal animal5 = new Animal(animalType1, territory2);
    public static final Animal animal6 = new Animal(animalType2, territory2);
    static {
        animal1.setId(1);
        animal2.setId(2);
        animal3.setId(3);
        animal4.setId(4);
        animal5.setId(5);
        animal6.setId(6);
    }


    static {
        territory1.setAnimals(List.of(animal1, animal2, animal3));
        territory2.setAnimals(List.of(animal4, animal5, animal6));

        animalType1.setAnimals(List.of(animal1, animal4, animal5));
        animalType2.setAnimals(List.of(animal2, animal6));
        animalType3.setAnimals(List.of(animal3));
    }
}
