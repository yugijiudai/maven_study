use itat_maven_test;
create table if not EXISTS  t_yugi(
  id int(10) auto_increment PRIMARY KEY,
  username VARCHAR (20),
  pass VARCHAR (20)
);