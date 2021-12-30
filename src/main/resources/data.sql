INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES ('master', 'password', 'master', 'master@localhost.com', 'MASTER', true, true, true, true, '2021-12-29', '2021-12-29');

INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES ('manager', 'password', 'manager', 'manager@localhost.com', 'MANAGER', true, true, true, true, '2021-12-29', '2021-12-29');

INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES ('userA', 'password', 'userA', 'userA@localhost.com', 'COMMON', true, true, true, true, '2021-12-29', '2021-12-29');

INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES ('userB', 'password', 'userB', 'userB@localhost.com', 'COMMON', true, true, true, true, '2021-12-29', '2021-12-29');