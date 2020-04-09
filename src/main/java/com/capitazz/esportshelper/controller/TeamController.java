package com.capitazz.esportshelper.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capitazz.esportshelper.model.Team;
import com.capitazz.esportshelper.service.TeamService;
import static com.capitazz.esportshelper.controller.ControllerUtils.getErrors;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String teamList(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        model.addAttribute("teams", teamService.getByFilter(filter));
        model.addAttribute("filter", filter);
        return "teamList";
    }

    @PostMapping
    public String addTeam(@Valid Team team, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.mergeAttributes(getErrors(bindingResult));
        }
        else {
            teamService.save(team);
            model.addAttribute("team", null);
        }

        model.addAttribute("teams", teamService.getAll());
        return "teamList";
    }
}
