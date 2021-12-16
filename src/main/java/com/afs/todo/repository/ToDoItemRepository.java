package com.afs.todo.repository;

import com.afs.todo.entity.ToDoItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoItemRepository extends MongoRepository<ToDoItem, String> {
    List<ToDoItem> findAllByDone(Boolean done);
}
