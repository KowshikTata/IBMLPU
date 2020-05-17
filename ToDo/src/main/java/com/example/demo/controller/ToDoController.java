package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ToDoDAO;
import com.example.demo.model.ToDo;

@RestController 
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class ToDoController {

	private ToDoDAO dao;

	public ToDoController(ToDoDAO dao) {
		super();
		this.dao = dao;
	}
	
	 @GetMapping("/todos")
	    public List<ToDo> getAllToDo() {
	        return dao.findAll();     
	        
	    }
	 
	 
	 @PostMapping("/todos")
	    public ToDo createToDo(@Valid @RequestBody ToDo todo) {
	        return dao.save(todo);
	    }
	 
	 @GetMapping("/todos/{id}")
	    public Optional<ToDo> getToDoById(@PathVariable(value = "id") Integer Id)
	    {
		 Optional<ToDo> todo=dao.findById(Id);
		return todo;
	    }
	 @DeleteMapping("/todos/{id}")
	 public void del(@PathVariable(value = "id") Integer Id)
	    {
		 dao.deleteById(Id);
		
	    }
	 @PutMapping("/todos/{id}")
	 public ResponseEntity<ToDo> updateToDoById(@PathVariable(value = "id") Integer Id,
	         @Valid @RequestBody ToDo todo)
	    {
		 ToDo found=dao.findById(Id).get();
		 if(found!=null)
		 {
			 found.setName(todo.getName());
			 found.setDescription(todo.getDescription());
			 dao.save(found);
		 }
		 
		return ResponseEntity.ok(found);
	    }
	 
}
