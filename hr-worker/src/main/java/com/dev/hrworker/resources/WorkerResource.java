package com.dev.hrworker.resources;

import com.dev.hrworker.entities.Worker;
import com.dev.hrworker.repositories.WorkerRepository;
import com.dev.hrworker.services.WorkerService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    @Autowired
    private WorkerService workerService;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Worker>> findById(@PathVariable Long id) {
        Optional<Worker> obj = Optional.ofNullable(workerService.findById(id));
        return ResponseEntity.ok(obj);
    }
}
