create user feedbackws IDENTIFIED by root
default  TABLESPACE users quota 100M on USERS;
/
grant create session to feedbackws;
/
grant create table to feedbackws;
/
grant create trigger to feedbackws;
/
grant create sequence to feedbackws;
/
grant alter any table to feedbackws;
/
grant delete any table to feedbackws;
/
grant drop any table to feedbackws;
/
create table theme (
  theme_id         NUMBER       NOT NULL,
  user_id          NUMBER       NOT NULL,
  theme_status     VARCHAR2(10) NOT NULL,
  last_active_date DATE         NOT NULL,
  CONSTRAINT pk_theme PRIMARY KEY (theme_id)
);
/
create table processing (
  request_id     NUMBER       NOT NULL,
  theme_id       NUMBER       NOT NULL,
  message_id     NUMBER       NOT NULL,
  process_status VARCHAR2(10) NOT NULL,
  question       VARCHAR2(1000),
  question_date  DATE,
  answer         VARCHAR2(1000),
  answer_date    DATE,
  CONSTRAINT pk_processing PRIMARY KEY (request_id),
  CONSTRAINT fk_theme FOREIGN KEY (theme_id)
    REFERENCES theme(theme_id) ON DELETE CASCADE
);
/
CREATE SEQUENCE hibernate_sequence
START WITH 1000 INCREMENT BY 1 NOMAXVALUE;
/
COMMIT



