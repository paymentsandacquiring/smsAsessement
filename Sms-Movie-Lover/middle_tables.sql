CREATE TABLE IF NOT EXISTS movie_genre_middle (
	movie_id integer,
	genre_id integer,
	FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY(genre_id) REFERENCES movie_genre(genre_id),
	PRIMARY KEY(movie_id, genre_id)
);

CREATE TABLE IF NOT EXISTS movie_publisher_middle (
	movie_id integer,
	publisher_id integer,
	FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY(publisher_id) REFERENCES movie_publisher(publisher_id),
	PRIMARY KEY(movie_id, publisher_id)
);

CREATE TABLE IF NOT EXISTS movie_cast_middle(
	movie_id integer,
	cast_id integer,
	FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY(cast_id) REFERENCES movie_cast(cast_id),
	PRIMARY KEY(cast_id, movie_id)
);

CREATE TABLE IF NOT EXISTS movie_rater_middle(
	movie_id integer,
	rater_id integer,
	rater_rating double precision,
	FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY(rater_id) REFERENCES movie_rater(rater_id),
	PRIMARY kEY(movie_id, rater_id)
);

CREATE TABLE IF NOT EXISTS user_rating(
	movie_id integer,
	user_id integer,
	user_rating double precision,
	FOREIGN KEY(movie_id) REFERENCES movie(movie_id),
	FOREIGN KEY(user_id) REFERENCES movie_user(user_id),
	PRIMARY KEY(movie_id, user_id)
);