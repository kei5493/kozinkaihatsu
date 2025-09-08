package com.kozinkaihatsu.app.repository.common;

import java.util.List;

import com.kozinkaihatsu.app.Record.FlowerNameRecord;

public interface FlowerNameMapper {
    /**
     * 花名称マスタから全データを取得する
     * @return 花名称マスタの全データ
     */
    List<FlowerNameRecord> selectAllFlowerName();
}