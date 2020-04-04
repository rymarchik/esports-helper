package com.capitazz.esportshelper.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capitazz.esportshelper.model.Team;
import com.capitazz.esportshelper.service.TeamService;

@Controller
@RequestMapping("/main")
public class MainController {

    private TeamService teamService;

    public MainController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        List<Team> teams = teamService.getAll();
        model.put("teams", teams);

        return "main";
    }

    @PostMapping
    public String addTeam(Team team) {
        teamService.save(team);

        return "redirect:/main";
    }

    @PostMapping("/filter")
    public String filterTeam(@RequestParam String filter, Map<String, Object> model) {
        List<Team> teams = teamService.getByFilter(filter);
        model.put("teams", teams);

        return "main";
    }
}
