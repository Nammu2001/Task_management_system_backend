package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GET /api/tasks?userId=1
    @GetMapping
    public ResponseEntity<List<Task>> getTasks(@RequestParam Long userId) {
        return ResponseEntity.ok(taskService.getTasksByUserId(userId));
    }

    // POST /api/tasks?userId=1  with Task JSON body
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestParam Long userId, @RequestBody Task task) {
        Task created = taskService.createTaskForUser(userId, task);
        return ResponseEntity.ok(created);
    }

    // PUT /api/tasks/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updated = taskService.updateTask(id, task);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/tasks/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Deleted");
    }
}
