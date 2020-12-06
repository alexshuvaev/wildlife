package com.alexshuvaev.wildlife.rest;

import com.alexshuvaev.wildlife.entity.AnimalType;
import com.alexshuvaev.wildlife.service.RootService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static com.alexshuvaev.wildlife.rest.RestEndpoints.ANIMALTYPE;

@RestController
@RequestMapping(value = ANIMALTYPE)
@Api(tags = {"animalType"})
public class AnimalTypeController extends AbstractController<AnimalType> {

    @Autowired
    public AnimalTypeController(RootService<AnimalType> service) {
        super(service);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public Page<AnimalType> getAll(
            @RequestParam(value = "page", defaultValue = DEFAULT_PAGE_NUM) Integer page,
            @RequestParam(value = "size", defaultValue = DEFAULT_PAGE_SIZE) Integer size) {
        return super.getAll(page, size);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public AnimalType get(@PathVariable int id) {
        return super.get(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public AnimalType create(@RequestBody AnimalType creatable) {
        return super.create(creatable);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public void update(@RequestBody AnimalType updatable, @PathVariable int id) {
        super.update(updatable, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable int id) {
       super.delete(id);
    }
}
