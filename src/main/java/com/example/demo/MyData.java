package com.example.demo;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
@Container(containerName = "demo")
public class MyData {

    @Id
    @PartitionKey
    private String id;

    private String data;
}
