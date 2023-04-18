package com.capitazz.esportshelper.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.capitazz.esportshelper.model.Match;
import com.capitazz.esportshelper.repository.MatchRepository;

/**
 * Сервис для работы с матчами {@link Match}.
 *
 * <p>Выполняет стандартные CRUD операции, используя базу данных.</p>
 */
@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    public Match get(Long id) {
        return matchRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    public Match save(Match match) {
        return matchRepository.save(match);
    }

    public void delete(Long id) {
        matchRepository.deleteById(id);
    }
}
