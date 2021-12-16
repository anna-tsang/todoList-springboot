package com.afs.todo.repository;

import com.afs.todo.entity.ToDoList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoListRepository extends MongoRepository<ToDoList, String> {
}
