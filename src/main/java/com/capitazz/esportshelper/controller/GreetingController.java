package com.capitazz.esportshelper.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capitazz.esportshelper.model.Team;
import com.capitazz.esportshelper.service.TeamService;

@Controller
public class GreetingController {

    private TeamService teamService;

    public GreetingController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String mainPage(Map<String, Object> model) {
        List<Team> teams = teamService.getAll();
        model.put("teams", teams);

        return "index";
    }

    @PostMapping
    public String addTeam(@RequestParam String name, @RequestParam Integer rank) {
        Team team = new Team(name, rank);
        teamService.save(team);

        return "redirect:";
    }

    @PostMapping("filter")
    public String filterTeam(@RequestParam String filter, Map<String, Object> model) {
        List<Team> teams = teamService.getByFilter(filter);
        model.put("teams", teams);

        return "index";
    }
}
