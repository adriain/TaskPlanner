INSERT INTO users (id, username, password, register_date) VALUES (0, 'Adriain', '$2a$10$E0SWZp0YiGvMVoJhXPIvkuvNGo7CoJgAQieH4U6oreVFAkn3AJ2.a', '2024-08-05');

INSERT INTO groups (id, name, description, creation_date) VALUES (0, 'Testing Group', 'This is a group for testing', '2024-08-05');

INSERT INTO user_access (id, user_id, group_id, join_date, is_admin, can_modify_tasks) VALUES (0, 0, 0, '2024-08-05', true, true);

INSERT INTO security_users (enabled, user_id, password, role, username) VALUES (true, 0, '$2a$10$E0SWZp0YiGvMVoJhXPIvkuvNGo7CoJgAQieH4U6oreVFAkn3AJ2.a', 'ADMIN', 'Adriain');