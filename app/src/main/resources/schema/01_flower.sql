-- 花マスタ
DROP VIEW IF EXISTS kozinkaihatsu.flower_list;
DROP TABLE IF EXISTS kozinkaihatsu.flower CASCADE;

CREATE TABLE kozinkaihatsu.flower (
    id           integer   NOT NULL,
    flower_name_id integer NOT NULL,
    flower_name  text      NOT NULL,
    color_id   integer   NOT NULL,
    color_name   character varying(20),
    image_file_name VARCHAR(255),
    PRIMARY KEY (id)
);

-- テーブルコメント
COMMENT ON TABLE kozinkaihatsu.flower IS '花マスタ';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower.id IS '花ID';
COMMENT ON COLUMN kozinkaihatsu.flower.flower_name_id IS '花の名前ID';
COMMENT ON COLUMN kozinkaihatsu.flower.flower_name IS '花の名前';
COMMENT ON COLUMN kozinkaihatsu.flower.color_id IS '色ID';
COMMENT ON COLUMN kozinkaihatsu.flower.color_name IS '色';
COMMENT ON COLUMN kozinkaihatsu.flower.image_file_name IS '画像';
