package ec.foxkey.crud.db.services;

import ec.foxkey.crud.db.entities.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonService {
    Flux<Person> list();
    Mono<Person> save(Person person);
    Mono<Person> update(Person person);
    Mono<Person> findById(String id);
    Mono<Void> delete(String id);
}
