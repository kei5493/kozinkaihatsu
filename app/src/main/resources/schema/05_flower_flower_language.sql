-- 花マスタ + 花言葉を1行でまとめて表示するビュー
DROP TABLE IF EXISTS kozinkaihatsu.flower_flower_language;

CREATE TABLE kozinkaihatsu.flower_flower_language (
    id INT NOT NULL,
    language_id INT NOT NULL,
    PRIMARY KEY (id, language_id),
    FOREIGN KEY (id) REFERENCES kozinkaihatsu.flower(id),
    FOREIGN KEY (language_id) REFERENCES kozinkaihatsu.flower_language(language_id)
);


-- ビューコメント
COMMENT ON TABLE kozinkaihatsu.flower_flower_language IS '花マスタと花言葉IDを結合した中間テーブル';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_flower_language.id IS '花ID（flowerマスタのID）';
COMMENT ON COLUMN kozinkaihatsu.flower_flower_language.language_id IS '花言葉ID（flower_languageマスタのID）';
