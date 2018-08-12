INSERT INTO movie(title, director, release_Date) VALUES
  ('MovieTitle', 'MovieDirector', '2018-08-11'),
  ('MovieTitle2', 'MovieDirector', '2018-08-11');

INSERT INTO comment(text, author, score, movie_id) VALUES
  ('A comment for a movie', 'John Doe', 4, 1),
  ('A comment for a movie', 'Jane Doe', 2, 1),
  ('A comment for a movie2', 'John Doe', 0, 2);
