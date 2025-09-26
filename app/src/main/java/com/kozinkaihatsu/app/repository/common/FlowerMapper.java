package com.kozinkaihatsu.app.repository.common;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.kozinkaihatsu.app.Record.FlowerRecord;
import com.kozinkaihatsu.app.Record.FlowerColorRecord;
import com.kozinkaihatsu.app.Record.FlowerNameRecord;

@Mapper
public interface FlowerMapper {
    // 登録
    Integer selectMaxId();
    /**
     * 新しい花名をマスタに追加
     * @param record FlowerNameRecord
     */
    void insertFlower(FlowerRecord record);

    // マスタ取得（プルダウン用）
    List<FlowerColorRecord> selectAllFlowerColor();
    List<FlowerNameRecord> selectAllFlowerName();
}