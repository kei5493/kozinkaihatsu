package com.kozinkaihatsu.app.Record;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlowerColorRecord {
    private Integer colorId;
    private String colorName;
    
}
