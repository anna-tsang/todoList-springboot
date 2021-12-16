package com.afs.todo.service;

import com.afs.todo.entity.ToDoItem;
import com.afs.todo.exception.NoMatchIdFoundException;
import com.afs.todo.repository.ToDoItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoItemService {
    private ToDoItemRepository toDoItemRepository;

    public ToDoItemService(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
    }

    public List<ToDoItem> findAllToDoList(){
        return toDoItemRepository.findAll();
    }

    public ToDoItem findToDoItemById(String id){
        return toDoItemRepository.findById(id).orElseThrow(NoMatchIdFoundException::new);
    }

    public ToDoItem create(ToDoItem todoItem) {
        return toDoItemRepository.insert(todoItem);
    }

    public ToDoItem updateToDoItem(String id, ToDoItem updatedToDoItem){
        ToDoItem toDoItem = findToDoItemById(id);
        if(updatedToDoItem.getDone() != null){
            toDoItem.setDone(updatedToDoItem.getDone());
        }
        if(updatedToDoItem.getText() != null){
            toDoItem.setText(updatedToDoItem.getText());
        }
        return toDoItemRepository.save(toDoItem);
    }

    public List<ToDoItem> findToDoListByDone(Boolean done) {
        return toDoItemRepository.findAllByDone(done);
    }

    public void delete(String id) {
        toDoItemRepository.delete(findToDoItemById(id));
    }

    public void deleteAll() {
        toDoItemRepository.deleteAll();
    }
}
