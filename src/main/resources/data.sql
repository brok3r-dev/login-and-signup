INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES
    ('master', 'password', 'master', 'master@localhost.com', 'MASTER', true, true, true, true, '2021-12-29 14:10:00.000', '2021-12-29 14:10:00.000'),
    ('manager', 'password', 'manager', 'manager@localhost.com', 'MANAGER', true, true, true, true, '2021-12-29 14:11:00.000', '2021-12-29 14:11:00.000'),
    ('userA', 'password', 'userA', 'userA@localhost.com', 'COMMON', true, true, true, true, '2021-12-29 14:12:00.000', '2021-12-29 14:12:00.000'),
    ('userB', 'password', 'userB', 'userB@localhost.com', 'COMMON', true, true, true, true, '2021-12-29 14:13:00.000', '2021-12-29 14:13:00.000');