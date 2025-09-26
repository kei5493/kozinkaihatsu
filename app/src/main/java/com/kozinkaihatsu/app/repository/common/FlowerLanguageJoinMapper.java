package com.kozinkaihatsu.app.repository.common;

import com.kozinkaihatsu.app.Record.FlowerLanguageJoinRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FlowerLanguageJoinMapper {
    void insert(FlowerLanguageJoinRecord record);
}
