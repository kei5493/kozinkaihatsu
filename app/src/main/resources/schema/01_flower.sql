-- 花マスタ
DROP TABLE IF EXISTS public.flower;
CREATE TABLE public.flower (
    flower_id   character varying(10) NOT NULL,
    flower_name text                  NOT NULL,
    color       character varying(20),
    PRIMARY KEY (flower_id)
);

-- テーブルコメント
COMMENT ON TABLE public.flower IS '花マスタ';

-- カラムコメント
COMMENT ON COLUMN public.flower.flower_id IS '花ID';
COMMENT ON COLUMN public.flower.flower_name IS '花の名前';
COMMENT ON COLUMN public.flower.color IS '色';
