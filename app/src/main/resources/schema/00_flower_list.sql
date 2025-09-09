-- 花一覧表示用ビュー
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
  FlowerLanguage AS (
    SELECT
      fl.flower_id,
      fl.flower_language
    FROM
      kozinkaihatsu.flower_language fl
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
    fb.id,
    fb.flower_name_id,
    fnm.flower_name,
    fb.color_id,
    fcm.color_name,
    fln.flower_language,
    fbl.start_month,
    fbl.end_month
FROM
    FlowerBase fb
    LEFT JOIN FlowerNameMaster fnm
        ON fb.flower_name_id = fnm.flower_name_id
    LEFT JOIN FlowerColorMaster fcm
        ON fb.color_id = fcm.color_id
    LEFT JOIN FlowerLanguage fln
        ON fb.id = fln.flower_id
    LEFT JOIN FlowerBloom fbl
        ON fb.id = fbl.flower_id;

-- ビューコメント
COMMENT ON VIEW kozinkaihatsu.flower_list_full IS '花マスタ + 花名前マスタ + 色マスタ + 花言葉 + 開花時期結合ビュー';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_list_full.id IS '花ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list_full.flower_name_id IS '花名前ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list_full.flower_name IS '花名前';
COMMENT ON COLUMN kozinkaihatsu.flower_list_full.color_id IS '色ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list_full.color_name IS '色名';
COMMENT ON COLUMN kozinkaihatsu.flower_list_full.flower_language IS '花言葉';
COMMENT ON COLUMN kozinkaihatsu.flower_list_full.start_month IS '開花開始月';
COMMENT ON COLUMN kozinkaihatsu.flower_list_full.end_month IS '開花終了月';