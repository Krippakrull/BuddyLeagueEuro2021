DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       user_id IDENTITY PRIMARY KEY,
                       user_name VARCHAR(250) NOT NULL,
                       password VARCHAR(250) NOT NULL,
                       email VARCHAR(250) NOT NULL,
                       points INT DEFAULT 0,
                       avatar VARCHAR(250)
);

DROP TABLE IF EXISTS teams;
CREATE TABLE teams (
                       team_id IDENTITY PRIMARY KEY,
                       team_name VARCHAR(250) NOT NULL,
                       flag_url VARCHAR(250) NOT NULL
);

INSERT INTO users (user_name, password, email, avatar)
VALUES('Adolf', 'abc123', 'adolf@mail.com', 'https://www.123.io/avatar.gif'),
      ('Emma', 'abc123', 'emma@mail.com', 'https://www.123.io/avatar.gif'),
      ('Sara', 'abc123', 'sara@mail.com', 'https://www.123.io/avatar.gif'),
      ('Anna', 'abc123', 'anna@mail.com', 'https://www.123.io/avatar.gif'),
      ('Tilde', 'abc123', 'tilde@mail.com', 'https://www.123.io/avatar.gif'),
      ('Lisa', 'abc123', 'lisa@mail.com', 'https://www.123.io/avatar.gif'),
      ('Sixten', 'abc123', 'sixten@mail.com', 'https://www.123.io/avatar.gif'),
      ('David', 'abc123', 'david@mail.com', 'https://www.123.io/avatar.gif'),
      ('Olle', 'abc123', 'olle@mail.com', 'https://www.123.io/avatar.gif');

INSERT INTO teams (team_name, flag_url)
VALUES('Turkey', 'https://www.123.com/flag.gif'),
      ('Italy', 'https://www.123.com/flag.gif'),
      ('Wales', 'https://www.123.com/flag.gif'),
      ('Switzerland', 'https://www.123.com/flag.gif'),
      ('Denmark', 'https://www.123.com/flag.gif'),
      ('Finland', 'https://www.123.com/flag.gif'),
      ('Belgium', 'https://www.123.com/flag.gif'),
      ('Russia', 'https://www.123.com/flag.gif'),
      ('Netherlands', 'https://www.123.com/flag.gif'),
      ('Ukraine', 'https://www.123.com/flag.gif'),
      ('Austria', 'https://www.123.com/flag.gif'),
      ('North Macedonia', 'https://www.123.com/flag.gif'),
      ('England', 'https://www.123.com/flag.gif'),
      ('Croatia', 'https://www.123.com/flag.gif'),
      ('Scotland', 'https://www.123.com/flag.gif'),
      ('Czech Republic', 'https://www.123.com/flag.gif'),
      ('Spain', 'https://www.123.com/flag.gif'),
      ('Sweden', 'https://www.123.com/flag.gif'),
      ('Poland', 'https://www.123.com/flag.gif'),
      ('Slovakia', 'https://www.123.com/flag.gif'),
      ('Hungary', 'https://www.123.com/flag.gif'),
      ('Portugal', 'https://www.123.com/flag.gif'),
      ('France', 'https://www.123.com/flag.gif'),
      ('Germany', 'https://www.123.com/flag.gif');
