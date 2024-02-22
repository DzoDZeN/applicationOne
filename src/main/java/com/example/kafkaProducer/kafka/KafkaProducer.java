package com.example.kafkaProducer.kafka;

import com.example.kafkaProducer.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducer {
    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private UserRepository userRepository;

    public void sendMessage(int id){
        kafkaTemplate.send("test", userRepository.findById(id).get().getFirstName());
        kafkaTemplate.send("test", userRepository.findById(id).get().getLastName());
        kafkaTemplate.send("test", userRepository.findById(id).get().getMail());
    }
}
