package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.User;

public interface UserRepo extends JpaRepository<User, Integer> {
}




