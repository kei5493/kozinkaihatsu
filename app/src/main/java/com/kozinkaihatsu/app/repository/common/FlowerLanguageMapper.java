package com.kozinkaihatsu.app.repository.common;

import java.util.List;

import com.kozinkaihatsu.app.Record.FlowerLanguageRecord;

public interface FlowerLanguageMapper {
    /**
     * 花言葉マスタから全データを取得する
     * @return 花言葉マスタの全データ
     */
    List<FlowerLanguageRecord> selectAllFlowerLanguage();
}
