package ec.foxkey.crud.db.services;

import ec.foxkey.crud.db.entities.Logs;
import ec.foxkey.crud.db.entities.Person;
import ec.foxkey.crud.db.entities.Statistics;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILogsService {
    Flux<Logs> list();
    Mono<Logs> save(Logs logs);
    Flux<Logs> findByType(int type);
    Mono<Integer> countByType(int type);
    Mono<Logs> deleteForType(int type);
    Flux<Integer> getMonths();
    Flux<Statistics> findAllProcess(int type);
}
