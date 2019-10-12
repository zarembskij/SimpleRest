package com.zarembski.nn.repository;

import com.zarembski.nn.domain.RequestCounter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<RequestCounter, Long> {
    @Query("SELECT r FROM RequestCounter r WHERE Login = ?1")
    List<RequestCounter> findByLogin(String login);
}
