use web_app;
create table users (user_id int not null auto_increment,
                    email varchar(40) not null,
                    first_name varchar(10) not null,
                    last_name varchar(20) not null,
                    address int not null,
                    user_password varchar(50) not null,
                    salt binary(16) not null,
                    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                    primary key (user_id));

create table addresses (address_id int not null auto_increment,
                    address varchar(100) not null,
                    user_id int not null,
                    primary key (address_id));

alter table users add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (address) references addresses (address_id);

alter table addresses add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (user_id) references users (user_id);
