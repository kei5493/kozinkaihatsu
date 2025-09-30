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

    /**
     * 花名称からIDを取得する
     * @param flowerName 花名称
     * @return flower_name_id（存在しなければnull）
     */
    Integer selectIdByName(String colorName);
}