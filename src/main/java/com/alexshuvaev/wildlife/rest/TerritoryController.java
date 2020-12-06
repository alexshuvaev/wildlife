package com.alexshuvaev.wildlife.rest;

import com.alexshuvaev.wildlife.dto.TerritoryDto;
import com.alexshuvaev.wildlife.entity.Animal;
import com.alexshuvaev.wildlife.entity.Territory;
import com.alexshuvaev.wildlife.service.RootService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.alexshuvaev.wildlife.rest.RestEndpoints.TERRITORY;
import static com.alexshuvaev.wildlife.utils.ToTerritoryDto.territoryDtoListCreate;

@RestController
@RequestMapping(value = TERRITORY)
@Api(tags = {"territory"})
public class TerritoryController extends AbstractController<Territory> {

    private final RootService<Animal> animalService;

    @Autowired
    public TerritoryController(RootService<Territory> service, RootService<Animal> animalService) {
        super(service);
        this.animalService = animalService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<TerritoryDto> getAllWithPopulation(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUM) Integer page,
            @RequestParam(value = "size", defaultValue = DEFAULT_PAGE_SIZE) Integer size) {
        Page<Territory> territories = super.getAll(page, size);
        Page<Animal> animals = animalService.getAll(Pageable.unpaged());
        List<TerritoryDto> territoryDtos = territoryDtoListCreate(territories.getContent(), animals.getContent());
        return new PageImpl<>(territoryDtos, territories.getPageable(), territories.getSize());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Territory get(@PathVariable int id) {
        return super.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Territory create(@RequestBody Territory creatable) {
        return super.create(creatable);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public void update(@RequestBody Territory updatable, @PathVariable int id) {
        super.update(updatable, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable int id) {
        super.delete(id);
    }
}
