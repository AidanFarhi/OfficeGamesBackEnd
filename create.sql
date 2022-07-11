create sequence office_game_sequence start 1 increment 1;
create sequence player_sequence start 1 increment 1;

create table office_game (
   id int8 not null,
    player_one_score int4,
    player_two_score int4,
    player_one_id int8,
    player_two_id int8,
    primary key (id)
);

create table player (
   id int8 not null,
    player_name varchar(255),
    primary key (id)
);

alter table office_game
add constraint FKb6t9e0rga6x3fuh0npsvnr4ao
foreign key (player_one_id)
references player;

alter table office_game
add constraint FKh3wcs28xrbimxw5i7fryxdk5v
foreign key (player_two_id)
references player;