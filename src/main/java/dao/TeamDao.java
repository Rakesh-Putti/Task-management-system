package dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.Team;
import dto.User;
import repo.TeamRepo;


@Repository
public class TeamDao {

    @Autowired
    TeamRepo teamRepo;

    @Autowired
    UserDao userDao;

   
    public Team saveTeam(Team team) {
        return teamRepo.save(team);
    }

    
    public Team addUserToTeam(int teamId, int userId) {
        Team team = fetchTeamById(teamId);
        User user = userDao.fetchUserById(userId);
        List<User> list = team.getUsers();
        list.add(user);
        team.setUsers(list);
        return saveTeam(team);
    }

    
    public Team fetchTeamById(int teamId) {
        return teamRepo.findById(teamId).get();
    }

    
    public List<Team> fetchAllTeams() {
        return teamRepo.findAll();
    }

}

