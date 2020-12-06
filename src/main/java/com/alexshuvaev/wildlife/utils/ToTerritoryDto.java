package com.alexshuvaev.wildlife.utils;

import com.alexshuvaev.wildlife.dto.TerritoryDto;
import com.alexshuvaev.wildlife.entity.Animal;
import com.alexshuvaev.wildlife.entity.Territory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class ToTerritoryDto {

    private ToTerritoryDto() {
    }



    public static List<TerritoryDto> territoryDtoListCreate(List<Territory> territories, List<Animal> animals){
        return territories.stream()
                .map(territory -> territoryDtoCreate(territory, animals)).collect(Collectors.toList());
    }

    private static TerritoryDto territoryDtoCreate(Territory territory, List<Animal> animals ) {
        Map<String, Long> populationGroupAnimalsCountMap = animals.stream()
                .collect(Collectors.groupingBy(
                        animal -> animal.getAnimalType().getPopulationsGroup().getName(),
                        Collectors.filtering(
                                animal -> animal.getTerritory().getId().equals(territory.getId()), Collectors.counting()
                        )
                ));
        return new TerritoryDto(
                territory.getId(),
                territory.getName(),
                territory.getAreaCode(),
                territory.getSquare(),
                territory.getPerson(),
                territory.getPhone(),
                populationGroupAnimalsCountMap);
    }
}
