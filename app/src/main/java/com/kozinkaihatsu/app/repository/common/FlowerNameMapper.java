package com.kozinkaihatsu.app.repository.common;

import java.util.List;
import com.kozinkaihatsu.app.Record.FlowerNameRecord;

public interface FlowerNameMapper {
    /**
     * 新しい花名をマスタに追加
     * @param record FlowerNameRecord
     */
    Integer selectMaxFlowerNameId();
    void insertFlowerName(FlowerNameRecord record);

    /**
     * 花名称マスタから全データを取得する
     * @return 花名称マスタの全データ
     */
    List<FlowerNameRecord> selectAllFlowerName();
}