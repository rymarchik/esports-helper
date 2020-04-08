package com.capitazz.esportshelper.model;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;

/**
 * Класс, описывающий сущность Матч.
 */
@Entity
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "winning_team_id", nullable = false)
    private Team winningTeam;

    @OneToOne
    @JoinColumn(name = "losing_team_id", nullable = false)
    private Team losingTeam;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GameMap map;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "match_score", nullable = false)
    private String matchScore;

    @ElementCollection
    @CollectionTable(name = "match_player_score",
        joinColumns = {@JoinColumn(name = "match_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "player_name")
    @Column(name = "score", nullable = false)
    private Map<String, String> playerScore;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(Team winningTeam) {
        this.winningTeam = winningTeam;
    }

    public Team getLosingTeam() {
        return losingTeam;
    }

    public void setLosingTeam(Team losingTeam) {
        this.losingTeam = losingTeam;
    }

    public GameMap getMap() {
        return map;
    }

    public void setMap(GameMap map) {
        this.map = map;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(String matchScore) {
        this.matchScore = matchScore;
    }

    public Map<String, String> getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(Map<String, String> playerScore) {
        this.playerScore = playerScore;
    }
}
