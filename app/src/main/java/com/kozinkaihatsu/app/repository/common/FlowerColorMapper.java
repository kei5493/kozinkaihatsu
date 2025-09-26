package com.kozinkaihatsu.app.repository.common;

import java.util.List;

import com.kozinkaihatsu.app.Record.FlowerColorRecord;

public interface FlowerColorMapper {
    /**
     * 新しい花名をマスタに追加
     * @param record FlowerNameRecord
     */
    Integer selectMaxColorId();
    void insertFlowerColor(FlowerColorRecord record);

    /**
     * 花色マスタから全データを取得する
     * @return 花色マスタの全データ
     */
    List<FlowerColorRecord> selectAllFlowerColor();
}