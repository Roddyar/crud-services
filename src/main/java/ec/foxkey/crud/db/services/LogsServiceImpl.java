package ec.foxkey.crud.db.services;

import ec.foxkey.crud.db.entities.Logs;
import ec.foxkey.crud.db.entities.Person;
import ec.foxkey.crud.db.entities.Statistics;
import ec.foxkey.crud.db.repository.ILogsRepo;
import ec.foxkey.crud.db.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;

@Service
public class LogsServiceImpl implements ILogsService {

    @Autowired
    private ILogsRepo iLogsRepo;

    @Override
    public Flux<Logs> list() {
        Iterable<Logs> logs = iLogsRepo.findAll();
        return Flux.fromIterable(logs);
    }

    @Override
    public Mono<Logs> save(Logs logs) {
        Logs logsReturn = iLogsRepo.save(logs);
        return Mono.just(logsReturn);
    }

    @Override
    public Flux<Logs> findByType(int type) {
        Iterable<Logs> logs = iLogsRepo.getAllByType(type);
        return Flux.fromIterable(logs);
    }

    @Override
    public Mono<Integer> countByType(int id) {
        Integer count = iLogsRepo.countByType(id);
        return Mono.just(count);
    }

    @Override
    public Mono<Logs> deleteForType(int type) {
        iLogsRepo.deleteByType(type);
        return Mono.empty();
    }

    @Override
    public Flux<Integer> getMonths() {
        Iterable<Integer> logs = iLogsRepo.getMonths();
        return Flux.fromIterable(logs);
    }

    @Override
    public Flux<Statistics> findAllProcess(int type) {
        Iterable<Statistics> logs = iLogsRepo.findAllProcess(type);
        return Flux.fromIterable(logs);
    }


}
