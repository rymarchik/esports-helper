INSERT INTO team (name, rank) VALUES ('na`vi', 1);
INSERT INTO team (name, rank) VALUES ('astralis', 2);


INSERT INTO player (nickname, team_id) VALUES ('s1mple', 1);
INSERT INTO player (nickname, team_id) VALUES ('electronic', 1);
INSERT INTO player (nickname, team_id) VALUES ('flamie', 1);
INSERT INTO player (nickname, team_id) VALUES ('BooMbI4', 1);
INSERT INTO player (nickname, team_id) VALUES ('Perfecto', 1);

INSERT INTO player (nickname, team_id) VALUES ('device', 2);
INSERT INTO player (nickname, team_id) VALUES ('dupreeh', 2);
INSERT INTO player (nickname, team_id) VALUES ('Xyp9x', 2);
INSERT INTO player (nickname, team_id) VALUES ('gla1ve', 2);
INSERT INTO player (nickname, team_id) VALUES ('Magisk', 2);


INSERT INTO match (winning_team_id, losing_team_id, match_score, map, date) VALUES (1, 2, '16-0', 'DUST2', '2020-04-01');
INSERT INTO match (winning_team_id, losing_team_id, match_score, map, date) VALUES (2, 1, '16-14', 'NUKE', '2020-04-01');

INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 's1mple', '30-5-5');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'electronic', '25-7-7');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'flamie', '22-10-10');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'BooMbI4', '20-9-12');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'Perfecto', '15-11-15');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'device', '20-12-3');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'dupreeh', '18-13-4');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'Xyp9x', '18-14-5');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'gla1ve', '14-15-6');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (1, 'Magisk', '14-16-7');

INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 's1mple', '33-25-5');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'electronic', '30-25-6');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'flamie', '25-25-7');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'BooMbI4', '20-25-8');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'Perfecto', '18-25-9');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'device', '35-15-5');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'dupreeh', '27-15-6');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'Xyp9x', '20-17-7');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'gla1ve', '20-16-8');
INSERT INTO match_player_score(match_id, player_name, score) VALUES (2, 'Magisk', '20-15-9');