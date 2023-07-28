package com.example.event.model.event;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEventModel{
    private String customerId;
    private String name;

}
