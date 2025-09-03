-- 花名前マスタ
DROP TABLE IF EXISTS kozinkaihatsu.flower_name;
CREATE TABLE kozinkaihatsu.flower_name (
    flower_name_id character varying(2) NOT NULL,
    flower_name    text                 NOT NULL,
    PRIMARY KEY (flower_name_id)
);

-- テーブルコメント
COMMENT ON TABLE kozinkaihatsu.flower_name IS '花名前マスタ';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_name.flower_name_id IS '花名前ID';
COMMENT ON COLUMN kozinkaihatsu.flower_name.flower_name IS '花の名前';
