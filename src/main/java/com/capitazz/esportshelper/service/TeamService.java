package com.capitazz.esportshelper.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.capitazz.esportshelper.model.Team;
import com.capitazz.esportshelper.repository.TeamRepository;

/**
 * Сервис для работы с командами {@link Team}.
 *
 * <p>Выполняет стандартные CRUD операции, используя базу данных.</p>
 */
@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    public List<Team> getByFilter(String filter) {
        return teamRepository.findByNameContaining(filter);
    }

    public Team get(Integer id) {
        return teamRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public void delete(Integer id) {
        teamRepository.deleteById(id);
    }
}
