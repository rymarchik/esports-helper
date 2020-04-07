package com.capitazz.esportshelper.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capitazz.esportshelper.model.Team;
import com.capitazz.esportshelper.service.TeamService;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String teamList(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        List<Team> teams = teamService.getByFilter(filter);

        model.addAttribute("teams", teams);
        model.addAttribute("filter", filter);

        return "teamList";
    }

    @PostMapping
    public String addTeam(Team team) {
        teamService.save(team);

        return "redirect:/teams";
    }
}
