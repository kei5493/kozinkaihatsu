-- 花マスタ + 花言葉を1行でまとめて表示するビュー
CREATE OR REPLACE VIEW kozinkaihatsu.flower_with_language AS
SELECT
    f.id AS flower_id,
    f.flower_name,
    f.color_name,
    STRING_AGG(fl.language, '、') AS flower_languages
FROM
    kozinkaihatsu.flower f
    LEFT JOIN kozinkaihatsu.flower_language fl
        ON f.id = fl.flower_id
GROUP BY
    f.id,
    f.flower_name,
    f.color_name;

-- ビューコメント
COMMENT ON VIEW kozinkaihatsu.flower_with_language IS '花マスタ + 花言葉を1行で結合したビュー';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_with_language.flower_id IS '花ID';
COMMENT ON COLUMN kozinkaihatsu.flower_with_language.flower_name IS '花名前';
COMMENT ON COLUMN kozinkaihatsu.flower_with_language.color_name IS '色名';
COMMENT ON COLUMN kozinkaihatsu.flower_with_language.flower_languages IS '花言葉（カンマ区切りで1行表示）';
