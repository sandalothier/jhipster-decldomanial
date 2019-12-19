package com.fisc.decldomanial.web.rest;

import com.fisc.decldomanial.service.DecldomanialKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/decldomanial-kafka")
public class DecldomanialKafkaResource {

    private final Logger log = LoggerFactory.getLogger(DecldomanialKafkaResource.class);

    private DecldomanialKafkaProducer kafkaProducer;

    public DecldomanialKafkaResource(DecldomanialKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
