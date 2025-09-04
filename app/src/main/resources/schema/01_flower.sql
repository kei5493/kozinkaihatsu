-- 花マスタ
DROP TABLE IF EXISTS kozinkaihatsu.flower;
CREATE TABLE kozinkaihatsu.flower (
    id           integer   NOT NULL,
    flower_name_id integer NOT NULL,
    flower_name  text      NOT NULL,
    color_id   integer   NOT NULL,
    color_name   character varying(20),
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
