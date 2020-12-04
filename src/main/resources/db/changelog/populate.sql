DELETE FROM animal;
DELETE FROM animal_type;
DELETE FROM territory;

INSERT IGNORE INTO animal_type(`name`, `animal_class`, `populations_group`)
VALUES ('Fish-type-1', 'AGNATHA', 'ENDANGEREDTYPE'),
       ('Fish-type-2', 'CHRONDRICHTYES', 'ENDANGEREDTYPE'),
       ('Amphibia-type-1', 'AMPHIBIA', 'BELOWNORMAL'),
       ('Amphibia-type-2', 'REPTILIA', 'NORMAL'),
       ('Mammalia-type-1', 'MAMMALIA', 'OVERPOPULATION'),
       ('Mammalia-type-2', 'MAMMALIA', 'ABOVENORMAL');

INSERT IGNORE INTO territory(`name`, `area_code`, `square`, `person`, `phone`)
VALUES ('Northwest', '094-123-NW', 231.31, 'Tom Hanks', '+230943431'),
       ('Southwest', '095-124-SW', 111, 'Margot Robbie', '+230953532'),
       ('Northeast', '095-124-NE', 111, 'Matt Damon', '+2309636'),
       ('Southeast', '095-124-SE', 111, 'Anne Hathaway', '+230973732');

INSERT IGNORE INTO animal(animal_type, territory)
VALUES (1, 1),
       (2, 2),
       (3, 3),
       (3, 3),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (4, 4),
       (5, 1),
       (5, 1),
       (5, 2),
       (5, 2),
       (5, 2),
       (5, 4),
       (5, 4),
       (5, 4),
       (5, 3),
       (5, 3),
       (5, 3),
       (6, 1),
       (6, 1),
       (6, 2),
       (6, 2),
       (6, 3),
       (6, 3);

