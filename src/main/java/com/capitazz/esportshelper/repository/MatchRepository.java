package com.capitazz.esportshelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitazz.esportshelper.model.Match;

/**
 * Репозиторий для работы с матчами {@link Match}.
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

}
