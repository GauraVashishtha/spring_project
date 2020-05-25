
drop user spring_student@localhost;
flush privileges;
create user spring_student@localhost identified by 'spring_student';
GRANT ALL PRIVILEGES ON * . * TO 'spring_student'@'localhost';