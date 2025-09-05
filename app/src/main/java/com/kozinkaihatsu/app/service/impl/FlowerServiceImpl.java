package com.kozinkaihatsu.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Entity.FlowersListEntity;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowerColorRecord;
import com.kozinkaihatsu.app.Record.FlowersListRecord;
import com.kozinkaihatsu.app.helper.FlowersListConverter;
import com.kozinkaihatsu.app.repository.common.FlowerColorMapper;
import com.kozinkaihatsu.app.repository.view.FlowersListMapper;
import com.kozinkaihatsu.app.service.FlowerService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class FlowerServiceImpl implements FlowerService {

    // 花マスタ用の Mapper（DBアクセス用）
    private final FlowersListMapper flowersListMapper;
    // Record ↔ Entity ↔ DTO 変換を行う Helper
    private final FlowersListConverter flowersListConverter;
    // 色マスタ用の Mapper（DBアクセス用）
    private final FlowerColorMapper flowerColorMapper;

    /**
     * 花マスタの全データを取得する
     * @return 花マスタの全件DTOリスト
     */
    @Override
    public List<FlowersListDTO> findAllFlower() {
        // ① DB から Record を取得
        List<FlowersListRecord> records = flowersListMapper.selectAllFlowersList();

        // ② Record → Entity に変換
        List<FlowersListEntity> entities = flowersListConverter.toEntityList(records);

        // ③ Entity → DTO に変換して返却
        return flowersListConverter.toDTOList(entities);
    }

    /**
     * 色マスタの全データを取得する
     * プルダウンの選択肢用
     * @return 色マスタの全件Recordリスト
     */
    @Override
    public List<FlowerColorRecord> getAllFlowerColor() {
        // Mapper を呼び出して色マスタを全件取得
        return flowerColorMapper.selectAllFlowerColor();
    }

    @Override
    public List<FlowersListDTO> findFlowerColor(FlowerSearchForm form) {
        // ① 条件付きでRecordを取得
        List<FlowersListRecord> records = flowersListMapper.selectSearchList(form);

        // ② Record → Entity
        List<FlowersListEntity> entities = flowersListConverter.toEntityList(records);

        // ③ Entity → DTO
        return flowersListConverter.toDTOList(entities);
    }
}