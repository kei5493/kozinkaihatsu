package com.kozinkaihatsu.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kozinkaihatsu.app.DTO.FlowerDTO;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Entity.FlowersListEntity;
import com.kozinkaihatsu.app.Record.FlowersListRecord;
import com.kozinkaihatsu.app.helper.FlowersListConverter;
import com.kozinkaihatsu.app.repository.view.FlowersListMapper;
import com.kozinkaihatsu.app.service.FlowerService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class FlowerServiceImpl implements FlowerService {

    private final FlowersListMapper flowersListMapper;
    private final FlowersListConverter flowersListConverter;

    @Override
    public List<FlowersListDTO> findAllFlower() {
        // ① DBからRecordを取得
        List<FlowersListRecord> records = flowersListMapper.selectAllFlower();

        // ② Record → Entity
        List<FlowersListEntity> entities = flowersListConverter.toEntityList(records);

        // ③ Entity → DTO
        return flowersListConverter.toDTOList(entities);
    }
}