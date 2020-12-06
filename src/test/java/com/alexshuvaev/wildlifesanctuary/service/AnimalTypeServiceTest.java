package com.alexshuvaev.wildlifesanctuary.service;

import com.alexshuvaev.wildlife.entity.AnimalType;
import com.alexshuvaev.wildlife.repository.RootRepository;
import com.alexshuvaev.wildlife.service.AnimalTypeService;
import com.alexshuvaev.wildlife.utils.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static com.alexshuvaev.wildlifesanctuary.service.util.TestData.animalType1;
import static com.alexshuvaev.wildlifesanctuary.service.util.TestData.animalType2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles(value = "test", profiles = "test")
class AnimalTypeServiceTest {

    @Mock
    RootRepository<AnimalType> repository;

    @InjectMocks
    AnimalTypeService service;

    @Test
    void get() {
        // given
        when(repository.findById(1)).thenReturn(Optional.of(animalType1));
        AnimalType animalType = service.get(1);
        // than
        assertEquals(animalType1, animalType);
        verify(repository, times(1)).findById(1);
    }

    @Test
    void get_NotFoundException() {
        // given
        when(repository.findById(999)).thenReturn(Optional.empty());
        // than
        NotFoundException notFoundException = assertThrows(NotFoundException.class, () -> service.get(999));
        assertEquals("no data with id=999", notFoundException.getMessage());
        verify(repository, times(1)).findById(999);
    }

    @Test
    void create() {
        // given
        when(repository.save(any())).thenReturn(animalType2);
        // than
        AnimalType animalType = service.create(animalType2);
        assertEquals(animalType2, animalType);
        verify(repository, times(1)).save(animalType2);
    }
}