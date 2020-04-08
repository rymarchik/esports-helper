INSERT INTO usr (id, username, password, email, active) VALUES (1, 'user', 'user', 'user@example.com', true);
INSERT INTO usr (id, username, password, email, active) VALUES (2, 'admin', 'admin', 'admin@example.com', true);

INSERT INTO user_role (user_id, role) VALUES (1, 'USER');
INSERT INTO user_role (user_id, role) VALUES (2, 'USER');
INSERT INTO user_role (user_id, role) VALUES (2, 'ADMIN');
-------------------------------------------------------------

INSERT INTO team (id, name, rank) VALUES (1, 'na`vi', 1);
INSERT INTO team (id, name, rank) VALUES (2, 'astralis', 2);


INSERT INTO player (id, nickname, team_id) VALUES (1, 's1mple', 1);
INSERT INTO player (id, nickname, team_id) VALUES (2, 'electronic', 1);
INSERT INTO player (id, nickname, team_id) VALUES (3, 'flamie', 1);
INSERT INTO player (id, nickname, team_id) VALUES (4, 'BooMbI4', 1);
INSERT INTO player (id, nickname, team_id) VALUES (5, 'Perfecto', 1);

INSERT INTO player (id, nickname, team_id) VALUES (6, 'device', 2);
INSERT INTO player (id, nickname, team_id) VALUES (7, 'dupreeh', 2);
INSERT INTO player (id, nickname, team_id) VALUES (8, 'Xyp9x', 2);
INSERT INTO player (id, nickname, team_id) VALUES (9, 'gla1ve', 2);
INSERT INTO player (id, nickname, team_id) VALUES (10, 'Magisk', 2);


INSERT INTO match (id, winning_team_id, losing_team_id, match_score, map, date) VALUES (1, 1, 2, '16-0', 'DUST2', '2020-04-01');
INSERT INTO match (id, winning_team_id, losing_team_id, match_score, map, date) VALUES (2, 2, 1, '16-14', 'NUKE', '2020-04-01');

INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 's1mple', '30-5-5');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'electronic', '25-7-7');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'flamie', '22-10-10');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'BooMbI4', '20-9-12');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'Perfecto', '15-11-15');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'device', '20-12-3');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'dupreeh', '18-13-4');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'Xyp9x', '18-14-5');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'gla1ve', '14-15-6');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (1, 'Magisk', '14-16-7');

INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 's1mple', '33-25-5');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'electronic', '30-25-6');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'flamie', '25-25-7');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'BooMbI4', '20-25-8');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'Perfecto', '18-25-9');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'device', '35-15-5');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'dupreeh', '27-15-6');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'Xyp9x', '20-17-7');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'gla1ve', '20-16-8');
INSERT INTO match_player_score (match_id, player_name, score) VALUES (2, 'Magisk', '20-15-9');