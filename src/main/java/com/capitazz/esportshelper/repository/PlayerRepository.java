package com.capitazz.esportshelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capitazz.esportshelper.model.Player;

/**
 * Репозиторий для работы с игроками {@link Player}.
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
