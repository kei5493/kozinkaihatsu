-- 色マスタ
DROP TABLE IF EXISTS public.flower_color;
CREATE TABLE public.flower_color (
    color_id   character varying(2) NOT NULL,
    color_name text                 NOT NULL,
    PRIMARY KEY (color_id)
);

-- テーブルコメント
COMMENT ON TABLE public.flower_color IS '色マスタ';

-- カラムコメント
COMMENT ON COLUMN public.flower_color.color_id IS '色ID';
COMMENT ON COLUMN public.flower_color.color_name IS '色名';
