package com.zarembski.nn.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    @JsonView(User.class)
    private Long id;

    @JsonView(User.class)
    private String login;

    @JsonView(User.class)
    private String name;

    @JsonView(User.class)
    private String type;

    @JsonView(User.class)
    private String avatarUrl;

    private Long followers;

    @JsonProperty("public_repos")
    private Long publicRepos;

    @JsonView(User.class)
    @JsonProperty("created_at")
    private String createdAt;

    @JsonView(User.class)
    private String calculations;

    public String getCalculations() {
        return (followers != 0 || publicRepos != 0) ? calculate(followers, publicRepos) : "ERR";
    }

    private String calculate(Long followers, Long publicRepos) {
        return String.valueOf(6D / (followers + (2 * publicRepos)));
    }
}
