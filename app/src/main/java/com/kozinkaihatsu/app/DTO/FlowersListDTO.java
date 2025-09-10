package com.kozinkaihatsu.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlowersListDTO {
    private Integer id;
    private Integer flowerNameId;
    private String flowerName;
    private Integer colorId;
    private String colorName;
    private String languages;
    private String flowerLanguageIds;
    private Integer startMonth;
    private Integer endMonth;  
    
}
