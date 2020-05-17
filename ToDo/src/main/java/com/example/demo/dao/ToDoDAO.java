package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.demo.model.ToDo;

@Repository
public interface ToDoDAO extends JpaRepository<ToDo,Integer>{

	@Query
    Page<ToDo> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
