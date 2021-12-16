package com.afs.todo.service;

import com.afs.todo.entity.ToDoItem;
import com.afs.todo.repository.ToDoItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
public class ToDoItemServiceTest {

    @Mock
    ToDoItemRepository toDoItemRepository;

    @InjectMocks
    ToDoItemService toDoItemService;

    @Test
    void should_return_all_todolist_when_find_all_given_todolist() {
        //given
        List<ToDoItem> toDoItemList = Arrays.asList(new ToDoItem("Do Homework", false));
        given(toDoItemRepository.findAll())
                .willReturn(toDoItemList);

        //when
        List<ToDoItem> actual = toDoItemService.findAllToDoList();

        //then
        assertEquals(toDoItemList, actual);
    }

    @Test
    void should_return_updated_todoitem_when_do_update_given_updated_todoitem() {
        //given
        ToDoItem toDoItem = new ToDoItem("1", "Do Homework", false);
        ToDoItem updatedToDoItem = new ToDoItem("1", "Do CSS", true);

        //when
        given(toDoItemRepository.findById(toDoItem.getId()))
                .willReturn(java.util.Optional.of(toDoItem));
        given(toDoItemRepository.save(toDoItem))
                .willReturn(updatedToDoItem);

        //then
        System.out.println(toDoItem.getText());
        System.out.println(updatedToDoItem.getText());
        ToDoItem actual = toDoItemService.updateToDoItem(toDoItem.getId(), updatedToDoItem);
        assertEquals(updatedToDoItem, actual);
    }

    @Test
    void should_return_todoitem_when_create_todoitem_given_todoitem() {
        //given
        ToDoItem todoItem = new ToDoItem( "do homework");
        //when
        given(toDoItemRepository.insert(todoItem)).willReturn(todoItem);
        //then
        ToDoItem actual =toDoItemService.create(todoItem);
        assertEquals(todoItem, actual);
    }

}
