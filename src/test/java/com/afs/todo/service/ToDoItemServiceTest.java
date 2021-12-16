package com.afs.todo.service;

import com.afs.todo.entity.ToDoItem;
import com.afs.todo.repository.ToDoListRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class ToDoItemServiceTest {

    @Mock
    ToDoListRepository toDoListRepository;

    @InjectMocks
    ToDoListService toDoListService;

    @Test
    void should_return_all_todolist_when_find_all_given_todolist() {
        //given
        List<ToDoItem> toDoItemList = Arrays.asList(new ToDoItem("Do Homework", false));
        given(toDoListRepository.findAll())
                .willReturn(toDoItemList);

        //when
        List<ToDoItem> actual = toDoListService.findAllToDoList();

        //then
        assertEquals(toDoItemList, actual);
    }

}
