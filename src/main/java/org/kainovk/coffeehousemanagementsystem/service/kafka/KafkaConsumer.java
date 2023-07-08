package org.kainovk.coffeehousemanagementsystem.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.kainovk.coffeehousemanagementsystem.dto.kafka.GrainIncomeMessage;
import org.kainovk.coffeehousemanagementsystem.service.GrainService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final GrainService grainService;

    @KafkaListener(topics = "grain-income", groupId = "my-group")
    private void listen(GrainIncomeMessage message) {
        log.info("Received message: {}", message);
        grainService.save(message);
    }
}
