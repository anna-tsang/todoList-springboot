package com.afs.todo.service;

import com.afs.todo.entity.ToDoList;
import com.afs.todo.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {
    private ToDoListRepository toDoListRepository;

    public ToDoListService(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    public List<ToDoList> findAllToDoList(){
        return toDoListRepository.findAll();
    }
}
