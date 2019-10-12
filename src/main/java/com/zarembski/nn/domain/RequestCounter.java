package com.zarembski.nn.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCounter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String login;
    private Integer requestCount;
}
