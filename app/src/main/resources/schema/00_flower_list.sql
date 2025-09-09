-- 花一覧表示用ビュー（flower + flower_name + flower_color + flower_with_language + flower_bloom）
CREATE OR REPLACE VIEW kozinkaihatsu.flower_list AS
WITH
  FlowerNameMaster AS (
    SELECT
      flower_name_id,
      flower_name
    FROM
      kozinkaihatsu.flower_name
  ),
  FlowerColorMaster AS (
    SELECT
      color_id,
      color_name
    FROM
      kozinkaihatsu.flower_color
  ),
  FlowerBase AS (
    SELECT
      f.id,
      f.flower_name_id,
      f.color_id
    FROM
      kozinkaihatsu.flower f
  ),
  FlowerWithLanguage AS (
    SELECT
      f.id AS flower_id,
      STRING_AGG(fl.language, '、') AS flower_languages,
      STRING_AGG(fl.language_id::text, ',') AS flower_language_ids
    FROM
      kozinkaihatsu.flower f
      LEFT JOIN kozinkaihatsu.flower_flower_language ffl
        ON f.id = ffl.flower_id
      LEFT JOIN kozinkaihatsu.flower_language fl
        ON ffl.language_id = fl.language_id
    GROUP BY f.id
  ),
  FlowerBloom AS (
    SELECT
      fb.flower_id,
      fb.start_month,
      fb.end_month
    FROM
      kozinkaihatsu.flower_bloom fb
  )
SELECT
    fb.id AS flower_id,
    fb.flower_name_id,
    fnm.flower_name,
    fb.color_id,
    fcm.color_name,
    fwl.flower_languages,
    fwl.flower_language_ids,
    fbl.start_month,
    fbl.end_month
FROM
    FlowerBase fb
    LEFT JOIN FlowerNameMaster fnm
        ON fb.flower_name_id = fnm.flower_name_id
    LEFT JOIN FlowerColorMaster fcm
        ON fb.color_id = fcm.color_id
    LEFT JOIN FlowerWithLanguage fwl
        ON fb.id = fwl.flower_id
    LEFT JOIN FlowerBloom fbl
        ON fb.id = fbl.flower_id;

-- ビューコメント
COMMENT ON VIEW kozinkaihatsu.flower_list IS '花マスタ + 花名前マスタ + 色マスタ + 花言葉（中間テーブル経由） + 開花時期結合ビュー';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_id IS '花ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_name_id IS '花名前ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_name IS '花名前';
COMMENT ON COLUMN kozinkaihatsu.flower_list.color_id IS '色ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list.color_name IS '色名';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_languages IS '花言葉（カンマ区切りで1行表示）';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_language_ids IS '花言葉ID（カンマ区切り）';
COMMENT ON COLUMN kozinkaihatsu.flower_list.start_month IS '開花開始月';
COMMENT ON COLUMN kozinkaihatsu.flower_list.end_month IS '開花終了月';