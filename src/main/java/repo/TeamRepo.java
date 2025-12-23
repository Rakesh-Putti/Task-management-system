package repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dto.Team;

public interface TeamRepo extends JpaRepository<Team, Integer> {
}

