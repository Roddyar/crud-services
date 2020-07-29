package ec.foxkey.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ec.foxkey.crud.db.services.IPersonService;
import ec.foxkey.crud.db.entities.Person;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "https://5f21a5700fa3a70008e4e056--amazing-lewin-ebf769.netlify.app")
public class PersonController {

    private static Logger log = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private IPersonService service;

    @GetMapping
    public Flux<Person> list() {
        return service.list();
    }

    @PostMapping
    public Mono<Person> save(@RequestBody Person person) {
        return service.save(person);
    }

    @PutMapping
    public Mono<Person> update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return service.findById(id).flatMap(maker -> service.delete(maker.getId()));
    }

    @GetMapping("/{id}")
    public Mono<Person> find(@PathVariable("id") String id) {
        return service.findById(id);
    }

}
