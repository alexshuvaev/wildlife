package com.alexshuvaev.wildlife.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AnimalClass {
    AGNATHA("jaw-less fish"),
    CHRONDRICHTYES("cartilaginous fish"),
    OSTEICHTHYES("bony fish"),
    AMPHIBIA("amphibians"),
    REPTILIA("reptiles"),
    AVES("birds"),
    MAMMALIA("mammals");

    private final String group;
}
