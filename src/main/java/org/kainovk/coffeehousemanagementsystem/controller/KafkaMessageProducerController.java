package org.kainovk.coffeehousemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kainovk.coffeehousemanagementsystem.dto.kafka.GrainIncomeMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KafkaMessageProducerController {

    private final KafkaTemplate<String, GrainIncomeMessage> kafkaTemplate;

    @PostMapping("/messages")
    public void sendMessage(@RequestBody GrainIncomeMessage grainIncomeMessage) {
        kafkaTemplate.send("grain-income", grainIncomeMessage);
        log.info("Sent message: {}", grainIncomeMessage);
    }
}
