package com.kozinkaihatsu.app.helper;

import java.util.List;

import org.mapstruct.Mapper;

import com.kozinkaihatsu.app.Entity.FlowersListEntity;
import com.kozinkaihatsu.app.Record.FlowersListRecord;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;

@Mapper(componentModel = "spring")
public interface FlowersListConverter {
    /**入れた後の結果
     * Record=>Entity
     * @param FlowersListRecord
     * @return FlowersListEntity
     */
    FlowersListEntity toEntity(FlowersListRecord record);
    //   ↑入れたい先                      ↑入れる元先

    /**
     * List<Record> => List<Entity>
     * @param List<FlowersListRecord>
     * @return List<FlowersListEntity>
     */
    List<FlowersListEntity> toEntityList(List<FlowersListRecord> records);
                                     // ↑リストのレコードをEntityに変換している（Mybatisがやっている）


    /**入れた後の結果
     * Entity=>DTO
     * @param FlowersListEntity
     * @return FlowersListDTO
     */
    FlowersListDTO toDTO(FlowersListEntity entity);
    //   ↑入れたい先                      ↑入れる元先

    /**
     * List<Entity> => List<DTO>
     * @param List<FlowerEntity>
     * @return List<FlowersListDTO>
     */
    List<FlowersListDTO> toDTOList(List<FlowersListEntity> entities);
    // ↑リストのEntityをDTOに変換している（Mybatisがやっている）
}

