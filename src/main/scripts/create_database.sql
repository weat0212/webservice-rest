create table users (user_id int not null auto_increment,
                    email varchar(40) not null,
                    first_name varchar(10) not null,
                    last_name varchar(20) not null,
                    user_password varchar(50) not null,
                    salt binary(16) not null,
                    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                    primary key (user_id));

