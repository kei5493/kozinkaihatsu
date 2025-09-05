-- 色マスタ
DROP TABLE IF EXISTS kozinkaihatsu.flower_color;
CREATE TABLE kozinkaihatsu.flower_color (
    color_id   integer NOT NULL,
    color_name text    NOT NULL,
    PRIMARY KEY (color_id)
);

-- テーブルコメント
COMMENT ON TABLE kozinkaihatsu.flower_color IS '色マスタ';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_color.color_id IS '色ID';
COMMENT ON COLUMN kozinkaihatsu.flower_color.color_name IS '色名';
