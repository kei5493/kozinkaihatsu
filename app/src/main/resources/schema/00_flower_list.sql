-- 花一覧表示用ビュー（flower + flower_name + flower_color + flower_language + flower_bloom）
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
  FlowerLanguageAgg AS (
    SELECT
      ffl.id AS id,
      STRING_AGG(fl.language, '、' ORDER BY fl.language_id) AS languages,
      STRING_AGG(fl.language_id::text, ',' ORDER BY fl.language_id) AS flower_language_ids
    FROM
      kozinkaihatsu.flower_flower_language ffl
      INNER JOIN kozinkaihatsu.flower_language fl
        ON ffl.language_id = fl.language_id
    GROUP BY ffl.id
  ),
  FlowerBloom AS (
    SELECT
      fb.flower_name_id,
      fb.start_month,
      fb.end_month
    FROM
      kozinkaihatsu.flower_bloom fb
  )
SELECT
    f.id AS id,
    f.flower_name_id,
    fnm.flower_name,
    f.color_id,
    fcm.color_name,
    fla.languages,
    fla.flower_language_ids,
    fbl.start_month,
    fbl.end_month
FROM
    kozinkaihatsu.flower f
    LEFT JOIN FlowerNameMaster fnm
      ON f.flower_name_id = fnm.flower_name_id
    LEFT JOIN FlowerColorMaster fcm
      ON f.color_id = fcm.color_id
    LEFT JOIN FlowerLanguageAgg fla
      ON f.id = fla.id   -- 色ごとに花言葉が違う
    LEFT JOIN FlowerBloom fbl
      ON f.flower_name_id = fbl.flower_name_id; -- 開花時期は花名前単位
      

-- ビューコメント
COMMENT ON VIEW kozinkaihatsu.flower_list IS '花マスタ + 花名前マスタ + 色マスタ + 花言葉（色ごとに異なる） + 開花時期を結合したビュー';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_list.id IS '花ID（色ごとにユニーク）';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_name_id IS '花名前ID（品種単位）';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_name IS '花名前';
COMMENT ON COLUMN kozinkaihatsu.flower_list.color_id IS '色ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list.color_name IS '色名';
COMMENT ON COLUMN kozinkaihatsu.flower_list.languages IS '花言葉（読点「、」区切りで1行表示、色ごとに異なる）';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_language_ids IS '花言葉ID（カンマ区切り、色ごとに異なる）';
COMMENT ON COLUMN kozinkaihatsu.flower_list.start_month IS '開花開始月（品種単位）';
COMMENT ON COLUMN kozinkaihatsu.flower_list.end_month IS '開花終了月（品種単位）';
