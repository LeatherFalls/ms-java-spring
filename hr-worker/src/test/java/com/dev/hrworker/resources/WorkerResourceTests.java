package com.dev.hrworker.resources;

import com.dev.hrworker.entities.Worker;
import com.dev.hrworker.services.WorkerService;
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
    private WorkerService workerService;

    @Mock
    private Worker Worker;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAllShouldReturnAllWorkersAndStatus200() {
        List<Worker> list = List.of(new Worker(ID, NAME, DAILY_INCOME));
        when(workerService.findAll()).thenReturn(list);

        ResponseEntity<List<Worker>> response = workerResource.findAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(1, response.getBody().size());
    }

    @Test
    public void findByIdShouldReturnWorkerWhenIdExistsAndStatus200() {
        when(workerService.findById(Mockito.anyLong())).thenReturn(new Worker(ID, NAME, DAILY_INCOME));
        ResponseEntity<Optional<Worker>> response = workerResource.findById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(ID, response.getBody().get().getId());
    }
}
