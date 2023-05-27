package com.burakbayramin.repository;

import com.burakbayramin.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todos, Long> {


}
