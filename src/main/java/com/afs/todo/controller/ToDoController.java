package com.afs.todo.controller;

import com.afs.todo.entity.ToDoList;
import com.afs.todo.service.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ToDoList")
public class ToDoController {

    private ToDoListService todoListService;

    public ToDoController(ToDoListService todoListService){
        this.todoListService = todoListService;
    }

    @GetMapping
    public List<ToDoList> getToDoList() {
        return todoListService.findAllToDoList();
    }

    @GetMapping(params = {"done"})
    public List<ToDoList> getToDoListByDone(@RequestParam Boolean done){
        return todoListService.findToDoListByDone(done);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ToDoList createToDoList(@RequestBody ToDoList todoList){
//        return todoListService.create(todoList);
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteToDoList(@PathVariable String id){
        todoListService.delete(id);
    }

}
