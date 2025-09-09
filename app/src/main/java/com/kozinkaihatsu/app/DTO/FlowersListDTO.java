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
    private String flowerNameId;
    private String flowerName;
    private String colorId;
    private String colorName;
    private Integer languageId; 
    private String language;      
    private Integer startMonth;   
    private Integer endMonth;    
    
}
