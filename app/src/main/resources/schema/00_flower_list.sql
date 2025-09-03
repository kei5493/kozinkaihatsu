-- 花一覧表示用ビュー
CREATE OR REPLACE VIEW kozinkaihatsu.v_flower_list AS
SELECT
    f.id,
    f.flower_name_id,
    fnm.flower_name AS flower_name,
    f.color_id,
    fc.color_name AS color_name
FROM
    kozinkaihatsu.flower f
    LEFT JOIN kozinkaihatsu.flower_name_master fnm
        ON f.flower_name_id = fnm.flower_name_id
    LEFT JOIN kozinkaihatsu.flower_color fc
        ON f.color_id = fc.color_id;

-- ビューコメント
COMMENT ON VIEW kozinkaihatsu.v_flower_list IS '花マスタ + 花名前マスタ + 色マスタ結合ビュー';

-- カラムコメント
COMMENT ON COLUMN kozinkaihatsu.v_flower_list.id IS '花ID';
COMMENT ON COLUMN kozinkaihatsu.v_flower_list.flower_name_id IS '花名前ID';
COMMENT ON COLUMN kozinkaihatsu.v_flower_list.flower_name IS '花名前';
COMMENT ON COLUMN kozinkaihatsu.v_flower_list.color_id IS '色ID';
COMMENT ON COLUMN kozinkaihatsu.v_flower_list.color_name IS '色名';
