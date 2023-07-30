--changeset ya:3
create table book
(
    id       serial primary key,
    book_name varchar(255) not null
);

insert into book (book_name)
values ('Мастер и Маргарита');
insert into book (book_name)
values ('Двенадцать стульев');
insert into book (book_name)
values ('Война и мир');
insert into book (book_name)
values ('Собачье сердце');
insert into book (book_name)
values ('Морфий');

create table  author
(
    id             serial primary key,
    author_full_name varchar(255) not null,
    books_qty       int          not null
);

insert into author (author_full_name, books_qty)
values ('Михаил Афанасьевич Булгаков', '3');
insert into author (author_full_name, books_qty)
values ('Илья́ Арно́льдович Ильф', '1');
insert into author (author_full_name, books_qty)
values ('Евге́ний Петро́вич Петро́в', '1');
insert into author (author_full_name, books_qty)
values ('Лев Николаевич Толстой', '1');

create table if not exists book_author
(
    id_book   int not null,
    id_author int not null,
    foreign key (id_book) references book (id),
    foreign key (id_author) references author (id),
    primary key (id_book, id_author)
);
insert into book_author(id_book, id_author)
values (1, 1);
insert into book_author(id_book, id_author)
values (2, 2);
insert into book_author(id_book, id_author)
values (2, 3);
insert into book_author(id_book, id_author)
values (3, 4);
insert into book_author(id_book, id_author)
values (4, 1);
insert into book_author(id_book, id_author)
values (5, 1);