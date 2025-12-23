package controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dto.Team;
import io.swagger.v3.oas.annotations.Operation;
import service.TeamService;
import util.ResponseStructure;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Operation(summary = "Create Team", description = "Admin creates a new team")
    @PostMapping("/create")
    public ResponseStructure<Team> createTeam(@RequestBody Team team, @RequestParam String currentRole) {
        return teamService.saveTeam(team, currentRole).getBody();
    }

    @Operation(summary = "Add User to Team", description = "Admin adds user/manager to a team")
    @PutMapping("/{teamId}/addUser/{userId}")
    public Team addUserToTeam(@PathVariable int teamId, @PathVariable int userId,
            @RequestParam String currentRole) {
        return teamService.addUserToTeam(teamId, userId, currentRole);
    }

    @Operation(summary = "Fetch Team by ID", description = "Fetch team details by ID")
    @GetMapping("/{teamId}")
    public ResponseStructure<Team> fetchTeamById(@PathVariable int teamId) {
        return teamService.fetchTeamById(teamId).getBody();
    }

    @Operation(summary = "Fetch All Teams", description = "Fetch all teams")
    @GetMapping("/all")
    public List<Team> fetchAllTeams() {
        return teamService.fetchAllTeams();
    }
}

