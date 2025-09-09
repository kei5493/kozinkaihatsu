DROP TABLE IF EXISTS kozinkaihatsu.flower_flower_language;
CREATE TABLE kozinkaihatsu.flower_flower_language (
    flower_id int NOT NULL REFERENCES kozinkaihatsu.flower(id),
    language_id int NOT NULL REFERENCES kozinkaihatsu.flower_language(language_id),
    PRIMARY KEY(flower_id, language_id)
);
