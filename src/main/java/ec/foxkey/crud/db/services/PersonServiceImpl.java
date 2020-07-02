package ec.foxkey.crud.db.services;

import ec.foxkey.crud.db.entities.Logs;
import ec.foxkey.crud.db.entities.Person;
import ec.foxkey.crud.db.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonRepo personRepo;

    @Autowired
    private ILogsService logsService;

    @Override
    public Flux<Person> list() {
        Iterable<Person> persons = personRepo.findAll();

        Logs log = new Logs();
        log.setType(1);
        log.setDay(new Timestamp(System.currentTimeMillis()));
        logsService.save(log);

        return Flux.fromIterable(persons);
    }

    @Override
    public Mono<Person> save(Person person) {
        person.setModified_in(new Timestamp(System.currentTimeMillis()));
        Person personReturn = personRepo.save(person);

        Logs log = new Logs();
        log.setType(2);
        log.setDay(new Timestamp(System.currentTimeMillis()));
        logsService.save(log);

        return Mono.just(personReturn);
    }

    @Override
    public Mono<Person> update(Person person) {
        person.setModified_in(new Timestamp(System.currentTimeMillis()));
        Person personReturn = personRepo.save(person);

        Logs log = new Logs();
        log.setType(3);
        log.setDay(new Timestamp(System.currentTimeMillis()));
        logsService.save(log);

        return Mono.just(personReturn);
    }

    @Override
    public Mono<Person> findById(String id) {
        Person personReturn = personRepo.findById(id).orElse(null);
        return Mono.just(personReturn);
    }

    @Override
    public Mono<Void> delete(String id) {
        personRepo.deleteById(id);

        Logs log = new Logs();
        log.setType(4);
        log.setDay(new Timestamp(System.currentTimeMillis()));
        logsService.save(log);

        return Mono.empty();
    }


}
