package com.yrmb.todo.service;

import com.yrmb.todo.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private ArrayList<Task> tasks;

    TaskService(){

        tasks = new ArrayList<Task>();

        // mock
        Task task1 = new Task(1, "Teste 1", LocalDateTime.now(), null);
        Task task2 = new Task(2, "Teste 2", LocalDateTime.now(), null);
        Task task3 = new Task(3, "Teste 3", LocalDateTime.now(), null);

        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);

    }

    public void create(Task task){
        tasks.add(task);
    }

    public void update(Task task){
        // to-do
    }

    public void delete(long id){
        tasks.remove(findById((id)));
    }

    public void deleteAll() {
        tasks.clear();
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(long id) {
        return tasks.stream().filter(t -> t.getId() == id).collect(Collectors.toList()).get(0);
    }

}