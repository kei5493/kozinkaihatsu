package com.kozinkaihatsu.app.service;
import java.util.List;

import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowerColorRecord;

public interface FlowerService {
    //花マスタの全データを取得する
    // @return　花マスタの全データ
    List<FlowersListDTO> findAllFlower();

    //色マスタ全件取得（プルダウン用）
    List<FlowerColorRecord> getAllFlowerColor();

    //色で絞り込み検索
    List<FlowersListDTO> findFlowerColor(FlowerSearchForm form);
}