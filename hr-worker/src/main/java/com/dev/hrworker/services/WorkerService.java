package com.dev.hrworker.services;

import com.dev.hrworker.entities.Worker;
import com.dev.hrworker.repositories.WorkerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    public Worker findById(Long id) {
        Optional<Worker> worker = workerRepository.findById(id);
        return worker.orElseThrow(() -> new ObjectNotFoundException(id, "Worker not found"));
    }
}
