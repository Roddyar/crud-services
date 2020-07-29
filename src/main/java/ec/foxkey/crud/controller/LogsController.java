package ec.foxkey.crud.controller;

import ec.foxkey.crud.db.entities.Logs;
import ec.foxkey.crud.db.entities.Statistics;
import ec.foxkey.crud.db.services.ILogsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/logs")
@CrossOrigin(origins = "https://5f21a5700fa3a70008e4e056--amazing-lewin-ebf769.netlify.app")
public class LogsController {

    private static Logger log = LoggerFactory.getLogger(LogsController.class);

    @Autowired
    private ILogsService service;

    @GetMapping
    public Flux<Logs> list() {
        return service.list();
    }

    @GetMapping("/list/{type}")
    public Flux<Logs> listByType(@PathVariable("type") int type) {
        return service.findByType(type);
    }

    @GetMapping("/count/{type}")
    public Mono<Integer> countByType(@PathVariable("type") int type) {
        return service.countByType(type);
    }

    @GetMapping("/mont")
    public Flux<Integer> getMonths() {
        return service.getMonths();
    }

    @GetMapping("/proc/{type}")
    public Flux<Statistics> findAllProcess(@PathVariable("type") int type) {
        return service.findAllProcess(type);
    }

}
