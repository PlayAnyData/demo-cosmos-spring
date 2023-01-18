package com.example.demo;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;

import java.util.List;

public interface MyDataRepository extends CosmosRepository<MyData, String> {

    @Query("SELECT count(1) FROM c")
    long countObjects();

    @Query("SELECT VALUE count(1) as counter FROM c")
    long countObjects2();

    @Query("SELECT count(1) as counter FROM c")
    List<MyDataProjection> countObjectsWrapped();
}
