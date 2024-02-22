package com.example.kafkaProducer.controller;



import com.example.kafkaProducer.service.GrpcDataService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class GrpcController {
    @Autowired
    GrpcDataService grpcDataService;
    @PostMapping("/grpc/{id}")
    public String get (@PathVariable(value = "id") int id){
        grpcDataService.get(id);
        return "Success";
    }
}
