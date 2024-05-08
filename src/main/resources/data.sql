INSERT INTO users (id, username, password, register_date) VALUES (0, 'Adriain', '1234', '2024-08-05');

INSERT INTO groups (id, name, description, creation_date) VALUES (0, 'Testing Group', 'This is a group for testing', '2024-08-05');

INSERT INTO user_access (id, user_id, group_id, join_date, is_admin, can_modify_tasks) VALUES (0, 0, 0, '2024-08-05', true, true);
