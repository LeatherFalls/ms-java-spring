package com.dev.hrpayroll.services;

import com.dev.hrpayroll.entities.Payment;
import com.dev.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, Integer days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", workerId.toString());

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
