-- 開花時期マスタ
DROP TABLE IF EXISTS kozinkaihatsu.flower_bloom;
CREATE TABLE kozinkaihatsu.flower_bloom (
    id SERIAL PRIMARY KEY,
    flower_name_id INT NOT NULL,
    start_month INT NOT NULL,
    end_month INT NOT NULL
);
