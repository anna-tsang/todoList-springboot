package com.afs.todo.controller;

import com.afs.todo.entity.ToDoItem;
import com.afs.todo.service.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("ToDoList")
public class ToDoController {

    private ToDoListService toDoListService;

    public ToDoController(ToDoListService toDoListService){
        this.toDoListService = toDoListService;
    }

    @GetMapping
    public List<ToDoItem> getToDoList() {
        return toDoListService.findAllToDoList();
    }

    @GetMapping(params = {"done"})
    public List<ToDoItem> getToDoListByDone(@RequestParam Boolean done){
        return toDoListService.findToDoListByDone(done);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoItem createToDoItem(@RequestBody ToDoItem todoItem){
        return toDoListService.create(todoItem);
    }

    @PutMapping("/{id}")
    public ToDoItem updateToDoItemDone(@PathVariable String id, @RequestBody ToDoItem todoItem){
        return toDoListService.updateToDoDone(id, todoItem);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteToDoItem(@PathVariable String id){
        toDoListService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAll(){
        toDoListService.deleteAll();
    }

}
