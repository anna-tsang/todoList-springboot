package com.afs.todo.controller;

import com.afs.todo.entity.ToDoItem;
import com.afs.todo.repository.ToDoItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ToDoItemControllerTest {
    public static final String TODOLIST_ENDPOINT = "/ToDoList";
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ToDoItemRepository toDoItemRepository;

    @BeforeEach
    void cleanRepository(){
        toDoItemRepository.deleteAll();
    }

    @Test
    void should_return_todolist_when_perform_get_given_todolist() throws Exception {
        //given
        ToDoItem toDoItemA = new ToDoItem("1","Do CSS");
        toDoItemRepository.insert(toDoItemA);
        ToDoItem toDoItemB = new ToDoItem("2","Do HTML");
        toDoItemRepository.insert(toDoItemB);
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.get(TODOLIST_ENDPOINT))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").isString())
                .andExpect((jsonPath("$[0].text").value("Do CSS")))
                .andExpect((jsonPath("$[0].done").value(false)));
    }

}
