package com.example.kafkaProducer.service;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.client.inject.GrpcClientBean;
import org.springframework.stereotype.Service;

@Service
public class GrpcDataService {
    @GrpcClient(value = "kafkaProducer")
    private GreetingServiceGrpc.GreetingServiceBlockingStub greetingServiceBlockingStub;

    public void get(int id) {
        GreetingServiceOuterClass.IdRequest request = GreetingServiceOuterClass
                .IdRequest.newBuilder()
                .setId(id)
                .build();
        GreetingServiceOuterClass.Response response = greetingServiceBlockingStub.greeting(request);
        System.out.println(response.getFirstName());
        System.out.println(response.getLastName());
        System.out.println(response.getMail());
    }
}

