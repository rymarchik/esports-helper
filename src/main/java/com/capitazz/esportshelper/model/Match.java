package com.capitazz.esportshelper.model;

import java.time.LocalDate;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс, описывающий сущность Матч.
 */
@Getter
@Setter
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

}
