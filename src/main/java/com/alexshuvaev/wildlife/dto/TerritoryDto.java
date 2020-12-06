package com.alexshuvaev.wildlife.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TerritoryDto {
    private Integer id;
    private String name;
    private String areaCode;
    private BigDecimal square;
    private String person;
    private String phone;
    Map<String, Long> populations;
}
