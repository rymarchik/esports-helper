package com.capitazz.esportshelper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Класс, описывающий сущность Игрок.
 */
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "team_id_fkey"))
    private Team team;

    public Player() {
    }

    public Integer getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Team getTeam() {
        return team;
    }
}
