package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
