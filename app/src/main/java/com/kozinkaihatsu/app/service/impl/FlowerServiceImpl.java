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
import com.kozinkaihatsu.app.Record.FlowerNameRecord;
import com.kozinkaihatsu.app.Record.FlowersListRecord;
import com.kozinkaihatsu.app.helper.FlowersListConverter;
import com.kozinkaihatsu.app.repository.common.FlowerBloomMapper;
import com.kozinkaihatsu.app.repository.common.FlowerColorMapper;
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
        List<Integer> startMonths = flowerBloomMapper.selectStartMonths();
        List<Integer> endMonths   = flowerBloomMapper.selectEndMonths();

        return FlowerSearchFormDTO.builder()
                .flowerColorRecords(colorRecords)
                .flowerNameRecords(nameRecords)
                .startMonths(startMonths) 
                .endMonths(endMonths)
                .build();
    }

    /**
     * フォームの内容を DTO に反映
     */
    @Override
    public FlowerSearchFormDTO giveSearchFormDTO(FlowerSearchForm form, FlowerSearchFormDTO dto) {
        dto.setSelectedColor(form.getColor());
        dto.setSelectedFlowerName(form.getSelectName());
        dto.setLanguageForm(form.getLanguageForm());
        dto.setSelectedStartMonth(form.getStartMonth());
        dto.setSelectedEndMonth(form.getEndMonth());
        return dto;
    }
}