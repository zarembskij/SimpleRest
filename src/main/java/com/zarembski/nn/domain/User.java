package com.zarembski.nn.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    private Long id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;

    @JsonProperty("created_at")
    private String createdAt;
}
