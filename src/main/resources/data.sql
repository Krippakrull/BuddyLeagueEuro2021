
INSERT INTO roles (name)
VALUES('ROLE_USER'),
('ROLE_MODERATOR'),
('ROLE_ADMIN');

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

INSERT INTO users (username, email, password)
VALUES('user', 'user@mail.com', '$2a$10$8PEbVuwWxaSLVBJG2jdW9ORMMJbcPME/zeKlTYjzDG3QYTUlhdQ5e'),
      ('mod', 'mod@mail.com', '$2a$10$8PEbVuwWxaSLVBJG2jdW9ORMMJbcPME/zeKlTYjzDG3QYTUlhdQ5e'),
      ('admin', 'admin@mail.com', '$2a$10$8PEbVuwWxaSLVBJG2jdW9ORMMJbcPME/zeKlTYjzDG3QYTUlhdQ5e');

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (3, 3);