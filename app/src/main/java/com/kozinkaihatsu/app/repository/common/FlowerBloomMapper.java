package com.kozinkaihatsu.app.repository.common;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.kozinkaihatsu.app.Record.FlowerBloomRecord;


@Mapper
public interface FlowerBloomMapper {
    void insertFlowerBloom(FlowerBloomRecord record);
    List<Integer> selectStartMonths();
    List<Integer> selectEndMonths();

}