package com.afs.todo.service;

import com.afs.todo.entity.ToDoItem;
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

    public List<ToDoItem> findAllToDoList(){
        return toDoListRepository.findAll();
    }

    public ToDoItem findToDoItemById(String id){
        return toDoListRepository.findById(id).orElseThrow(NoMatchIdFoundException::new);
    }

    public ToDoItem create(ToDoItem todoItem) {
        return toDoListRepository.insert(todoItem);
    }

    public ToDoItem updateToDoDone(String id, Boolean done){
        return toDoListRepository.save(toDoList);
    }

    public List<ToDoItem> findToDoListByDone(Boolean done) {
        return toDoListRepository.findAllByDone(done);
    }

    public void delete(String id) {
        toDoListRepository.delete(findToDoItemById(id));
    }

}
