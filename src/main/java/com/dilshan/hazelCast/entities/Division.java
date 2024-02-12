package com.dilshan.hazelCast.entities;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Division implements Serializable {
    private Integer id;
    private String name;
    private int staffCount;
}
