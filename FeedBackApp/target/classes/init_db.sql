create user feedbackapp IDENTIFIED by root
default  TABLESPACE users quota 100M on USERS;
/
grant create session to feedbackapp;
/
grant create table to feedbackapp;
/
grant create trigger to feedbackapp;
/
grant create sequence to feedbackapp;
/
grant alter any table to feedbackapp;
/
grant delete any table to feedbackapp;
/
grant drop any table to feedbackapp;
-- Создание таблиц БД (Users, Roles, Themes, Messages)
-- Таблица для хранения данных пользователя

CREATE TABLE feedbackapp.users (
  user_id       INTEGER       NOT NULL,
  user_name     VARCHAR2(20)  NOT NULL,
  user_password VARCHAR2(255) NOT NULL,
  first_name    VARCHAR2(50),
  last_name     VARCHAR2(50),
  create_date   DATE          NOT NULL,
  last_visit    DATE          NOT NULL,
  CONSTRAINT pk_user PRIMARY KEY (user_id)
);
-- Таблица для ролей пользователя (ADMIN, USER, GUEST и т.д.)
CREATE TABLE feedbackapp.roles (
  role_id   INTEGER      NOT NULL,
  role_name VARCHAR2(50) NOT NULL,
  CONSTRAINT pk_role PRIMARY KEY (role_id)
);
-- Таблица маппинга пользователь - роль
CREATE TABLE feedbackapp.user_role_map (
  user_id INTEGER NOT NULL,
  role_id INTEGER NOT NULL,
  UNIQUE (user_id, role_id),
  CONSTRAINT fk_user FOREIGN KEY (user_id)
     REFERENCES users (user_id) ON DELETE CASCADE,
  CONSTRAINT fk_roles FOREIGN KEY (role_id)
     REFERENCES roles (role_id) ON DELETE CASCADE
);

-- Таблица для хранения темы модуля обратной связи
CREATE TABLE feedbackapp.themes (
  theme_id     INTEGER       NOT NULL,
  author_id    INTEGER       NOT NULL,
  theme_text   VARCHAR2(255) NOT NULL,
  theme_date   DATE          NOT NULL,
  theme_status VARCHAR2(10) DEFAULT 'open',
  CONSTRAINT pk_theme PRIMARY KEY (theme_id),
  CONSTRAINT fk_theme_user FOREIGN KEY (author_id)
     REFERENCES USERS(user_id) ON DELETE CASCADE
);

CREATE TABLE feedbackapp.messages (
  message_id        INTEGER        NOT NULL,
  parent_theme      INTEGER        NOT NULL,
  message_text      VARCHAR2(1000) NOT NULL,
  message_date      DATE           NOT NULL,
  message_direction VARCHAR2(10)   NOT NULL,
  message_status    VARCHAR2(10)   NOT NULL,
  CONSTRAINT pk_message PRIMARY KEY (message_id),
  CONSTRAINT fk_mess_theme FOREIGN KEY (parent_theme)
  REFERENCES themes (theme_id) ON DELETE CASCADE
);

CREATE SEQUENCE hibernate_sequence
START WITH 1000 INCREMENT BY 1 NOMAXVALUE;
COMMIT;

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');
COMMIT;

