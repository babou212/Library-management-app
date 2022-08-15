INSERT INTO users (id, email, first_name, last_name) VALUES (4,'bob_johnson34@gmail.com', 'bob', 'johnson');
INSERT INTO items (id, isbn, author, media_type, title, release_year) VALUES (6, '9780140817744', 'George Orwell', 'BOOK', 'Nineteen Eighty-Four', '1949-06-08');
INSERT INTO loans (id, due_date, issue_date, number_renews, item_id, library_user_id) VALUES (5, '2022-09-12', '2022-08-15', 0, 6, 4);

INSERT INTO users (id, email, first_name, last_name) VALUES (7,'john_allen4@gmail.com', 'john', 'allen');
INSERT INTO items (id, isbn, author, media_type, title, release_year) VALUES (8, '9780439362139', 'J. K. Rowling', 'BOOK', 'Harry Potter and the Philosopher''s stone', '1997-06-26');
INSERT INTO loans (id, due_date, issue_date, number_renews, item_id, library_user_id) VALUES (10, '2022-09-12', '2022-08-15', 9, 8, 7);

INSERT INTO users (id, email, first_name, last_name) VALUES (11,'sofia1245@gmail.com', 'sofia', 'symth');
INSERT INTO items (id, isbn, author, media_type, title, release_year) VALUES (12, '9780340960196', 'Frank Herbert', 'BOOK', 'Dune', '1965-08-11');
INSERT INTO loans (id, due_date, issue_date, number_renews, item_id, library_user_id) VALUES (13, '2022-09-12', '2022-08-15', 0, 12, 11);

INSERT INTO users (id, email, first_name, last_name) VALUES (14,'unclebob123@gmail.com', 'Robert', 'Martin');
INSERT INTO items (id, isbn, author, media_type, title, release_year) VALUES (15, '9780132350884', 'Robert Cecil Martin', 'BOOK', 'Clean Code', '2008-08-01');
INSERT INTO loans (id, due_date, issue_date, number_renews, item_id, library_user_id) VALUES (16, '2022-09-12', '2022-08-15', 0, 15, 14);