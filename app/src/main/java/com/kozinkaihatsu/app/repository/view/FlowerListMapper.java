package com.kozinkaihatsu.app.repository.view;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.kozinkaihatsu.app.Record.FlowersListRecord;

public interface FlowerListMapper {
    /**
     * 花マスタから全データを取得する
     * @return 花マスタの全データ
     */
    List<FlowersListRecord> selectAllFlowerList();
}