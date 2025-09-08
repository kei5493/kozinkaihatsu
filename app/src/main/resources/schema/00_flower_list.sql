-- 花一覧表示用ビュー（CTE で整理版）
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
  )
SELECT
    fb.id,
    fb.flower_name_id,
    fnm.flower_name,
    fb.color_id,
    fcm.color_name
FROM
    FlowerBase fb
    LEFT JOIN FlowerNameMaster fnm
        ON fb.flower_name_id = fnm.flower_name_id
    LEFT JOIN FlowerColorMaster fcm
        ON fb.color_id = fcm.color_id;

-- ビューコメント
COMMENT ON VIEW kozinkaihatsu.flower_list IS '花マスタ + 花名前マスタ + 色マスタ結合ビュー';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.flower_list.id IS '花ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_name_id IS '花名前ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list.flower_name IS '花名前';
COMMENT ON COLUMN kozinkaihatsu.flower_list.color_id IS '色ID';
COMMENT ON COLUMN kozinkaihatsu.flower_list.color_name IS '色名';
