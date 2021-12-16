package com.afs.todo.service;

import com.afs.todo.entity.ToDoList;
import com.afs.todo.exception.NoMatchIdFoundException;
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

    public ToDoList findToDoListById(String id){
        return toDoListRepository.findById(id).orElseThrow(NoMatchIdFoundException::new);
    }

    public ToDoList create(ToDoList todoList) {
        return toDoListRepository.insert(todoList);
    }

    public List<ToDoList> findToDoListByDone(Boolean done) {
        return toDoListRepository.findAllByDone(done);
    }

    public void delete(String id) {
        toDoListRepository.delete(findToDoListById(id));
    }
}
