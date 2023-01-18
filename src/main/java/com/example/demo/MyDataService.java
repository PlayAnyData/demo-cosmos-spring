package com.example.demo;

import com.azure.spring.data.cosmos.exception.CosmosAccessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MyDataService {

    private final MyDataRepository myDataRepository;

    @PostConstruct
    public void getRepositoryData(){
        myDataRepository.save(MyData.builder().id(UUID.randomUUID().toString()).data("dummy").build());
        myDataRepository.save(MyData.builder().id(UUID.randomUUID().toString()).data("dummy").build());

        try {
            //Does not work (missing value)
            System.out.println(myDataRepository.countObjects());
        } catch (IllegalArgumentException illegalArgumentException){
            System.err.println(illegalArgumentException);
        }

        try {
            //Does not work because of the alias with value
            System.out.println(myDataRepository.countObjects2());
        } catch (CosmosAccessException cosmosAccessException){
            System.err.println(cosmosAccessException);
        }

        //This works (projection into new classe, but then it is a list of course)
        System.out.println(myDataRepository.countObjectsWrapped().get(0));
    }
}
