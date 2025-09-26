package com.kozinkaihatsu.app.Record;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlowerNameRecord {
    private Integer flowerNameId;
    private String flowerName;
}
