package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dao.TeamDao;
import dto.Team;
import exception.TeamNotFound;
import exception.UnauthorizedException;
import util.ResponseStructure;


@Service
public class TeamService {

    @Autowired
    TeamDao teamDao;

    @Autowired
    ResponseStructure<Team> responseStructure;

    
    public ResponseEntity<ResponseStructure<Team>> saveTeam(Team team, String currentRole) {
        if (!currentRole.equals("ADMIN")) {
            throw new UnauthorizedException("Only Admin can create teams");
        }
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Team created successfully");
        responseStructure.setData(teamDao.saveTeam(team));
        return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
    }

    
    public Team addUserToTeam(int teamId, int userId, String currentRole) {
        if (!currentRole.equals("ADMIN")) {
            throw new UnauthorizedException("Only Admin can add users to team");
        }
        return teamDao.addUserToTeam(teamId, userId);
    }

   
    public ResponseEntity<ResponseStructure<Team>> fetchTeamById(int teamId) {
        Team team = teamDao.fetchTeamById(teamId);
        if (team != null) {
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMessage("Team fetched successfully");
            responseStructure.setData(team);
            return new ResponseEntity<>(responseStructure, HttpStatus.FOUND);
        } else {
            throw new TeamNotFound();
        }
    }

   
    public List<Team> fetchAllTeams() {
        return teamDao.fetchAllTeams();
    }
}

