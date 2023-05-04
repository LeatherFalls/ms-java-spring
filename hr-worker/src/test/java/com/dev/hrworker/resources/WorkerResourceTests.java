package com.dev.hrworker.resources;

import com.dev.hrworker.entities.Worker;
import com.dev.hrworker.repositories.WorkerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkerResourceTests {
    private static final Long ID = 1L;
    private static final String NAME = "Bob";
    private static final Double DAILY_INCOME = 200.0;

    @InjectMocks
    private WorkerResource workerResource;

    @Mock
    private WorkerRepository workerRepository;

    @Mock
    private Worker Worker;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllShouldReturnAllWorkers() {
        List<Worker> list = List.of(new Worker(ID, NAME, DAILY_INCOME));
        when(workerRepository.findAll()).thenReturn(list);

        ResponseEntity<List<Worker>> response = workerResource.findAll();

        Assertions.assertNotNull(response);
        System.out.println(response.getBody().get(0).getName());
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(1, response.getBody().size());
    }

    @Test
    public void findByIdShouldReturnWorkerWhenIdExists() {
        Optional<Worker> optionalWorker = Optional.of(new Worker(ID, NAME, DAILY_INCOME));
        when(workerRepository.findById(Mockito.anyLong())).thenReturn(optionalWorker);

        ResponseEntity<Optional<Worker>> response = workerResource.findById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(ID, response.getBody().get().getId());
    }
}
