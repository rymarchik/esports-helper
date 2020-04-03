package com.capitazz.esportshelper.model;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "winning_team_id", foreignKey = @ForeignKey(name = "winning_team_id_fkey"))
    private Team winningTeam;

    @OneToOne
    @JoinColumn(name = "losing_team_id", foreignKey = @ForeignKey(name = "losing_team_id_fkey"))
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
        joinColumns = {@JoinColumn(name = "match_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "match_id_fkey"))})
    @MapKeyColumn(name = "player_name")
    @Column(name = "score")
    private Map<String, String> playerScore;


    public Integer getId() {
        return id;
    }

    public Team getWinningTeam() {
        return winningTeam;
    }

    public Team getLosingTeam() {
        return losingTeam;
    }

    public GameMap getMap() {
        return map;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMatchScore() {
        return matchScore;
    }

    public Map<String, String> getPlayerScore() {
        return playerScore;
    }
}
