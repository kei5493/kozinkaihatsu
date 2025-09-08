package com.kozinkaihatsu.app.helper;

import java.util.List;

import org.mapstruct.Mapper;

import com.kozinkaihatsu.app.Entity.FlowersListEntity;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowersListRecord;

@Mapper(componentModel = "spring")
public interface FlowersListSearchConverter {
    /**入れた後の結果
     * Form=>Entity
     * @param FlowerSearchForm
     * @return FlowersListEntity
     */
    FlowersListEntity toEntityFromForm(FlowerSearchForm form);
    //   ↑入れたい先                      ↑入れる元先

    /**
     * List<Form> => List<Entity>
     * @param List<FlowerSearchForm>
     * @return List<FlowersListEntity>
     */
    List<FlowersListEntity> toEntityList(List<FlowerSearchForm> forms);
                                     // ↑リストのレコードをEntityに変換している（Mybatisがやっている）


    /**入れた後の結果
     * Entity=>Record
     * @param FlowersListEntity
     * @return FlowersListRecord
     */
    FlowersListRecord toRecord(FlowersListEntity entity);
    //   ↑入れたい先                      ↑入れる元先

    /**
     * List<Entity> => List<Record>
     * @param List<FlowerEntity>
     * @return List<FlowersListRecord>
     */
    List<FlowersListRecord> toRecordList(List<FlowersListEntity> entities);
    // ↑リストのEntityをDTOに変換している（Mybatisがやっている）
}

