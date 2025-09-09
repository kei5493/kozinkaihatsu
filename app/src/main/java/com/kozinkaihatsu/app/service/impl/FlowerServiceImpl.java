package com.kozinkaihatsu.app.service.impl;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Entity.FlowersListEntity;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowerBloomRecord;
import com.kozinkaihatsu.app.Record.FlowerColorRecord;
import com.kozinkaihatsu.app.Record.FlowerLanguageRecord;
import com.kozinkaihatsu.app.Record.FlowerNameRecord;
import com.kozinkaihatsu.app.Record.FlowersListRecord;
import com.kozinkaihatsu.app.helper.FlowersListConverter;
import com.kozinkaihatsu.app.repository.common.FlowerBloomMapper;
import com.kozinkaihatsu.app.repository.common.FlowerColorMapper;
import com.kozinkaihatsu.app.repository.common.FlowerLanguageMapper;
import com.kozinkaihatsu.app.repository.common.FlowerNameMapper;
import com.kozinkaihatsu.app.repository.view.FlowersListMapper;
import com.kozinkaihatsu.app.service.FlowerService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class FlowerServiceImpl implements FlowerService {

    private final FlowersListMapper flowersListMapper;
    private final FlowersListConverter flowersListConverter;
    private final FlowerColorMapper flowerColorMapper;
    private final FlowerNameMapper flowerNameMapper;
    private final FlowerLanguageMapper flowerLanguageMapper;
    private final FlowerBloomMapper flowerBloomMapper;

    /**
     * 検索条件に応じた花リストを取得する
     */
    @Override
    public List<FlowersListDTO> flowersListDTO(FlowerSearchForm form) {
        List<FlowersListRecord> records = flowersListMapper.selectSearchList(form);
        List<FlowersListEntity> entities = flowersListConverter.toEntityList(records);
        return flowersListConverter.toDTOList(entities);
    }

    /**
     * 検索画面用 DTO を取得（キャッシュ付き）
     */
    @Cacheable("flowerSearchFormDTO")
    @Override
    public FlowerSearchFormDTO getSearchFormDTO() {
        List<FlowerColorRecord> colorRecords = flowerColorMapper.selectAllFlowerColor();
        List<FlowerNameRecord> nameRecords = flowerNameMapper.selectAllFlowerName();
        List<FlowerBloomRecord> bloomRecords = flowerBloomMapper.selectAllFlowerBloom();
        List<FlowerLanguageRecord> languageRecords = flowerLanguageMapper.selectAllFlowerLanguage();

        return FlowerSearchFormDTO.builder()
                .flowerColorRecords(colorRecords)
                .flowerNameRecords(nameRecords)
                .flowerBloomRecords(bloomRecords)
                .flowerLanguageRecords(languageRecords)
                .build();
    }

    /**
     * フォームの内容を DTO に反映
     */
    @Override
    public FlowerSearchFormDTO giveSearchFormDTO(FlowerSearchForm form, FlowerSearchFormDTO dto) {
        dto.setSelectedColor(form.getSelectedColor());
        dto.setSelectedFlowerName(form.getSelectedFlowerName());
        dto.setSelectedFlowerLanguage(form.getSelectedFlowerLanguage());
        dto.setSelectedStartMonth(form.getSelectedStartMonth());
        dto.setSelectedEndMonth(form.getSelectedEndMonth());
        return dto;
    }
}