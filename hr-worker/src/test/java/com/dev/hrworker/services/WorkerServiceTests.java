package com.dev.hrworker.services;

import com.dev.hrworker.entities.Worker;
import com.dev.hrworker.repositories.WorkerRepository;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorkerServiceTests {
    private static final Long ID = 1L;
    private static final String NAME = "Bob";
    private static final Double DAILY_INCOME = 200.0;

    @InjectMocks
    private WorkerService workerService;

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
        Mockito.when(workerRepository.findAll()).thenReturn(list);

        List<Worker> response = workerService.findAll();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(1, response.size());
    }

    @Test
    public void findByIdShouldReturnWorkerWhenIdExists() {
        Mockito.when(workerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Worker(ID, NAME, DAILY_INCOME)));

        Worker response = workerService.findById(ID);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(ID, response.getId());
        Assertions.assertEquals(NAME, response.getName());
        Assertions.assertEquals(DAILY_INCOME, response.getDailyIncome());
    }
}
