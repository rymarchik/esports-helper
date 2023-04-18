package com.capitazz.esportshelper.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.capitazz.esportshelper.model.Player;
import com.capitazz.esportshelper.repository.PlayerRepository;

/**
 * Сервис для работы с игроками {@link Player}.
 *
 * <p>Выполняет стандартные CRUD операции, используя базу данных.</p>
 */
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    public Player get(Long id) {
        return playerRepository.findById(id)
            .orElseThrow(NoSuchElementException::new);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }

    public void delete(Long id) {
        playerRepository.deleteById(id);
    }
}
