package com.dev.hrworker;

import com.dev.hrworker.resources.WorkerResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HrWorkerApplicationTests {
	@Autowired
	private WorkerResource workerResource;
	@Test
	void contextLoads() {
		assertThat(workerResource).isNotNull();
	}
}
