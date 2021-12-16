package com.afs.todo.controller;

import com.afs.todo.entity.ToDoItem;
import com.afs.todo.service.ToDoItemService;
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
public class ToDoItemController {

    private ToDoItemService toDoItemService;

    public ToDoItemController(ToDoItemService toDoItemService){
        this.toDoItemService = toDoItemService;
    }

    @GetMapping
    public List<ToDoItem> getToDoList() {
        return toDoItemService.findAllToDoList();
    }

    @GetMapping(params = {"done"})
    public List<ToDoItem> getToDoListByDone(@RequestParam Boolean done){
        return toDoItemService.findToDoListByDone(done);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToDoItem createToDoItem(@RequestBody ToDoItem todoItem){
        return toDoItemService.create(todoItem);
    }

    @PutMapping("/{id}")
    public ToDoItem updateToDoItemDone(@PathVariable String id, @RequestBody ToDoItem todoItem){
        return toDoItemService.updateToDoItem(id, todoItem);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteToDoItem(@PathVariable String id){
        toDoItemService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteAll(){
        toDoItemService.deleteAll();
    }

}
