package com.afs.todo.controller;

import com.afs.todo.entity.ToDoItem;
import com.afs.todo.repository.ToDoItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

    @Test
    void should_return_new_todolist_when_perform_post_given_new_todoitem() throws Exception {
        //given
        String newCompany = "{\n" +
                "        \"id\": \"61bb072f9d895d624693914b\",\n" +
                "        \"text\": \"Do CSS ar\",\n" +
                "        \"done\": true\n" +
                "    }";
        //when
        //then
        mockMvc.perform((MockMvcRequestBuilders.post(TODOLIST_ENDPOINT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newCompany)))
                .andExpect(status().isCreated())
                .andExpect((jsonPath("$.text").value("Do CSS ar")));
    }

    @Test
    void should_update_todoitem_when_perform_put_given_todolist_id_and_updated_todoitem() throws Exception {
        //given
        ToDoItem toDoItem = new ToDoItem("Do CSS");
        toDoItemRepository.insert(toDoItem);
        String updatedToDoItem = "{\n" +
                "    \"id\": 1,\n" +
                "    \"text\": \"DO HW\"\n" +
                "}";

        //when
        mockMvc.perform(MockMvcRequestBuilders.put(TODOLIST_ENDPOINT + "/{id}", toDoItem.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updatedToDoItem))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value("DO HW"));
    }

    @Test
    void should_delete_todoitem_when_perform_delete_given_todoitem_id() throws Exception {
        //given
        ToDoItem company = new ToDoItem( "Do CSS");
        toDoItemRepository.insert(company);
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.delete(TODOLIST_ENDPOINT+"/{id}", company.getId()))
                .andExpect(status().isNoContent());
    }

}
