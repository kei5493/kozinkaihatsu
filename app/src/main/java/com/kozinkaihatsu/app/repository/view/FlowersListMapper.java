package com.kozinkaihatsu.app.repository.view;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowersListRecord;

@Mapper
public interface FlowersListMapper {
    /**
     * 花マスタから全データを取得する
     * @return 花マスタの全データ
     */
    List<FlowersListRecord> selectAllFlowersList();

     /**
     * 花一覧ビューから検索条件に応じて取得
     * @param form 検索フォーム（色IDなど）
     * @return 条件に合致する花一覧
     */
    List<FlowersListRecord> selectSearchList(@Param("form") FlowerSearchForm form);
}
