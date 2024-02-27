package com.example.kafkaProducer.controller;

import com.example.kafkaProducer.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducer kafkaProducer;
    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/kafka/{id}")
    public String send(@PathVariable(value = "id") int id){
        kafkaProducer.sendMessage(id);
        return "Success";
    }
}
