package com.alexshuvaev.wildlife.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PopulationsGroup {
    OVERPOPULATION("Overpopulation"),
    ABOVENORMAL("Above normal"),
    NORMAL("Normal"),
    BELOWNORMAL("Below normal"),
    ENDANGEREDTYPE("Endangered type");

    private final String name;
}
