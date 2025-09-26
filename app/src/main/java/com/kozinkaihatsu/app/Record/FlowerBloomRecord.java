package com.kozinkaihatsu.app.Record;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlowerBloomRecord {
    private Integer flowerNameId;
    private Integer startMonth;  // 開花開始月
    private Integer endMonth;    // 開花終了月
}
