package com.afs.todo.exception;

public class NoMatchIdFoundException extends RuntimeException{

    public NoMatchIdFoundException(){
        super("No match ID found");
    }

}
