package com.kozinkaihatsu.app.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowersListEntity {
    private Integer id;
    private Integer flowerNameId;
    private String flowerName;
    private Integer colorId;
    private String colorName;
}
