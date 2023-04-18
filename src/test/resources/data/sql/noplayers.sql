CREATE TABLE IF NOT EXISTS PLAYER (
  id int,
  firstname text,
  lastname text,
  weight int,
  height int,
  country_code text
);

CREATE TABLE IF NOT EXISTS PLAYER_LAST (
  player_id int,
  last int
);
