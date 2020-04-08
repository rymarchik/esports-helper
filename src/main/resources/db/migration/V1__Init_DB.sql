create sequence hibernate_sequence start 1 increment 1;

create table player (
    id       int8         not null,
    nickname varchar(255) not null,
    team_id  int8,
    primary key (id)
);

create table team (
    id   int8         not null,
    name varchar(255) not null,
    rank int4         not null,
    primary key (id)
);

create table match (
    id              int8         not null,
    winning_team_id int8         not null,
    losing_team_id  int8         not null,
    map             varchar(255) not null,
    match_score     varchar(255) not null,
    date            date         not null,
    primary key (id)
);

create table match_player_score (
    match_id    int8         not null,
    player_name varchar(255) not null,
    score       varchar(255) not null,
    primary key (match_id, player_name)
);

create table usr (
    id              int8         not null,
    username        varchar(255) not null,
    password        varchar(255) not null,
    email           varchar(255) not null,
    avatar          varchar(255),
    active          boolean,
    activation_code varchar(255),
    primary key (id)
);

create table user_role (
    user_id int8         not null,
    role    varchar(255) not null,
    primary key (user_id, role)
);

alter table player
    add constraint team_player_fk
    foreign key (team_id) references team;

alter table match
    add constraint losing_team_match_fk
    foreign key (losing_team_id) references team;

alter table match
    add constraint winning_team_match_fk
    foreign key (winning_team_id) references team;

alter table match_player_score
    add constraint match_player_score_match_fk
    foreign key (match_id) references match;

alter table user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;
