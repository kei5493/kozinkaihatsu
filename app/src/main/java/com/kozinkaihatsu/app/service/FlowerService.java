package com.kozinkaihatsu.app.service;
import java.util.List;

import com.kozinkaihatsu.app.DTO.FlowersListDTO;

public interface FlowerService {
    /**
     * 花マスタの全データを取得する
     * @return　花マスタの全データ
     */
    List<FlowersListDTO> findAllFlower();

}