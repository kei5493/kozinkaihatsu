package com.kozinkaihatsu.app.repository.view;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kozinkaihatsu.app.Record.FlowersListRecord;

@Mapper
public interface FlowersListMapper {
    /**
     * 花マスタから全データを取得する
     * @return 花マスタの全データ
     */
    List<FlowersListRecord> selectAllFlower();
}