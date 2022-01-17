INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES ('master', '$2a$10$vFMe0fj1R5SG0k.beZH/Yuj5JhBdMhhUvIQO/47NLAY.lCa0.fLbm', 'master', 'master@localhost.com', 'ROLE_MASTER', true, true, true, true, '2021-12-29', '2021-12-29');

INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES ('manager', '$2a$10$vFMe0fj1R5SG0k.beZH/Yuj5JhBdMhhUvIQO/47NLAY.lCa0.fLbm', 'manager', 'manager@localhost.com', 'ROLE_MANAGER', true, true, true, true, '2021-12-29', '2021-12-29');

INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES ('userA', '$2a$10$vFMe0fj1R5SG0k.beZH/Yuj5JhBdMhhUvIQO/47NLAY.lCa0.fLbm', 'userA', 'userA@localhost.com', 'ROLE_VIEWER', true, true, true, true, '2021-12-29', '2021-12-29');

INSERT INTO user (id, password, name, email, authority, non_expired, non_locked, credential_non_expired, enabled, created_at, modified_at)
VALUES ('userB', '$2a$10$vFMe0fj1R5SG0k.beZH/Yuj5JhBdMhhUvIQO/47NLAY.lCa0.fLbm', 'userB', 'userB@localhost.com', 'ROLE_VIEWER', true, true, true, true, '2021-12-29', '2021-12-29');