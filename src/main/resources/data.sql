insert into categories (id, name) values
    (gen_random_uuid(), 'Zdrowie'),
    (gen_random_uuid(), 'Zwierzęta'),
    (gen_random_uuid(), 'Uroda i Styl'),
    (gen_random_uuid(), 'Kultura'),
    (gen_random_uuid(), 'Turystyka'),
    (gen_random_uuid(), 'Edukacja'),
    (gen_random_uuid(), 'Gry'),
    (gen_random_uuid(), 'Hobby'),
    (gen_random_uuid(), 'Dom i ogród'),
    (gen_random_uuid(), 'Biznes'),
    (gen_random_uuid(), 'Finanse'),
    (gen_random_uuid(), 'Kulinaria'),
    (gen_random_uuid(), 'Komputery'),
    (gen_random_uuid(), 'Osobiste'),
    (gen_random_uuid(), 'Motoryzacja'),
    (gen_random_uuid(), 'Polityka'),
    (gen_random_uuid(), 'Praca'),
    (gen_random_uuid(), 'Prezenty'),
    (gen_random_uuid(), 'Zakupy'),
    (gen_random_uuid(), 'Elektronika'),
    (gen_random_uuid(), 'Rozrywka'),
    (gen_random_uuid(), 'Sex'),
    (gen_random_uuid(), 'Związki'),
    (gen_random_uuid(), 'Inne');

select * from questions;
insert into questions (id, name, category_id) values
           (gen_random_uuid(), 'Gdzie najlepiej spędzić wakacje w Polsce', (select id from categories where name = 'Turystyka')),
           (gen_random_uuid(), 'Gdzie najlepiej spędzić wakacje w Europie', (select id from categories where name = 'Turystyka'));

insert into questions (id, name, category_id) values
            (gen_random_uuid(), 'Dlaczego warto uczyć się programowania', (select id from categories where name = 'Edukacja')),
            (gen_random_uuid(), 'Dlaczego Java jest dobrym językiem na start', (select id from categories where name = 'Edukacja'));

insert into questions (id, name, category_id) values
    (gen_random_uuid(), 'Jakie są najzdrowsze warzywa?', (select id from categories where name = 'Zdrowie'));

insert into answers (id, name, question_id) values
                                                (gen_random_uuid(), 'Marchewka', (select id from questions where name = 'Jakie są najzdrowsze warzywa?')),
                                                (gen_random_uuid(), 'Brokuł', (select id from questions where name = 'Jakie są najzdrowsze warzywa?')),
                                                (gen_random_uuid(), 'Dynia', (select id from questions where name = 'Jakie są najzdrowsze warzywa?')),
                                                (gen_random_uuid(), 'Groch', (select id from questions where name = 'Jakie są najzdrowsze warzywa?'));


insert into answers (id, name, question_id) values
                                                (gen_random_uuid(), 'Gdańsk', (select id from questions where name = 'Gdzie najlepiej spędzić wakacje z Polsce')),
                                                (gen_random_uuid(), 'Bieszczady', (select id from questions where name = 'Gdzie najlepiej spędzić wakacje z Polsce')),
                                                (gen_random_uuid(), 'Mazury', (select id from questions where name = 'Gdzie najlepiej spędzić wakacje z Polsce'));

