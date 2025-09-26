package com.kozinkaihatsu.app.repository.common;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kozinkaihatsu.app.Record.FlowerLanguageRecord;

@Mapper
public interface FlowerLanguageMapper {
     // 花言葉名から ID を取得
    Integer selectIdByLanguage(@Param("language") String language);

    // 新規花言葉を追加
    void insert(FlowerLanguageRecord record);
}
