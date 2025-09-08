package com.kozinkaihatsu.app.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Entity.FlowersListEntity;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowerColorRecord;
import com.kozinkaihatsu.app.Record.FlowersListRecord;
import com.kozinkaihatsu.app.helper.FlowersListConverter;
import com.kozinkaihatsu.app.repository.common.FlowerColorMapper;
import com.kozinkaihatsu.app.repository.common.FlowerNameMapper;
import com.kozinkaihatsu.app.repository.view.FlowersListMapper;
import com.kozinkaihatsu.app.service.FlowerService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class FlowerServiceImpl implements FlowerService {

    // 花マスタ用の Mapper（検索結果取得用）
    private final FlowersListMapper flowersListMapper;

    // Record ↔ Entity ↔ DTO 変換を行う Helper
    private final FlowersListConverter flowersListConverter;

    // 色マスタ用の Mapper（プルダウン用）
    private final FlowerColorMapper flowerColorMapper;

    // 名前マスタ用の Mapper（プルダウン用）
    private final FlowerNameMapper flowerNameMapper;

    /**
     * 検索条件に応じた花リストを取得する
     * @param form 検索フォーム
     * @return 検索結果のDTOリスト
     */
    @Override
    public List<FlowersListDTO> flowersListDTO(FlowerSearchForm form) {
        // ① 条件付きでRecordを取得
        List<FlowersListRecord> records = flowersListMapper.selectSearchList(form);

        // ② Record → Entity
        List<FlowersListEntity> entities = flowersListConverter.toEntityList(records);

        // ③ Entity → DTO
        return flowersListConverter.toDTOList(entities);
    }

    /**
     * 検索画面のプルダウンデータを取得する（キャッシュあり）
     * 色リスト・名称リストを保持する
     * @return FlowerSearchFormDTO
     */
    @Override
@Cacheable("flowerSearchForm")  // 初回のみDBアクセス、以降キャッシュ利用
public FlowerSearchFormDTO getSearchFormDTO() {
    return FlowerSearchFormDTO.builder()
            .flowerColorRecords(flowerColorMapper.selectAllFlowerColor())  // 色マスタ（プルダウン用）
            .flowerNameRecords(flowerNameMapper.selectAllFlowerName())    // 名前マスタ（プルダウン用）
            .build();
}

/**
 * 入力フォームの内容をDTOに反映させる
 * （検索後も選択した条件を保持するため）
 */
@Override
public FlowerSearchFormDTO giveSearchFormDTO(FlowerSearchForm form, FlowerSearchFormDTO dto) {
    dto.setSelectedColor(form.getColor());
    dto.setSelectedFlowerName(form.getSelectFlowerName());
    return dto;
}
}