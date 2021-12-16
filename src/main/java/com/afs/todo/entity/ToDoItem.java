package com.afs.todo.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document
public class ToDoItem {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String text;
    private Boolean done;

    public ToDoItem(String id, String text, Boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }
    public ToDoItem(String text, Boolean done) {
        this.text = text;
        this.done = done;
    }

    public ToDoItem(String text) {
        this.text = text;
        this.done = false;
    }

    public ToDoItem(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
