package com.kozinkaihatsu.app.repository.common;

import java.util.List;

import com.kozinkaihatsu.app.Record.FlowerBloomRecord;


public interface FlowerBloomMapper {
    
    /**
     * 開花時期マスタから全データを取得する
     * @return 開花時期マスタの全データ
     */
    List<FlowerBloomRecord> selectAllFlowerBloom();
}