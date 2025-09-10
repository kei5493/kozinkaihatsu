-- 花言葉マスタ
DROP TABLE IF EXISTS kozinkaihatsu.flower_flower_language;
DROP TABLE IF EXISTS kozinkaihatsu.flower_language;
CREATE TABLE kozinkaihatsu.flower_language (
    language_id serial PRIMARY KEY,
    language text NOT NULL
);

-- テーブルコメント
COMMENT ON TABLE kozinkaihatsu.flower_language IS '花言葉マスタ';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_language.language_id IS '花言葉ID';
COMMENT ON COLUMN kozinkaihatsu.flower_language.language IS '花言葉';
