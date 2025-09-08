package com.kozinkaihatsu.app.repository.common;

import java.util.List;

import com.kozinkaihatsu.app.Record.FlowerColorRecord;

public interface FlowerColorMapper {
    /**
     * 花色マスタから全データを取得する
     * @return 花色マスタの全データ
     */
    List<FlowerColorRecord> selectAllFlowerColor();
}