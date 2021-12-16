package com.afs.todo.controller;

import com.afs.todo.entity.ToDoList;
import com.afs.todo.service.ToDoListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
