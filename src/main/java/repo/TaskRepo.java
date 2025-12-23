package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {
}
