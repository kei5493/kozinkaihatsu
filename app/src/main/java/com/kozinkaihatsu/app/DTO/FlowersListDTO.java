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
    private Integer id; //花id
    private Integer flowerNameId; //花名称id
    private String flowerName; //花名称
    private Integer colorId; //色id
    private String colorName; //色名
    private String languages; //花言葉
    private String flowerLanguageIds; //花言葉id
    private Integer startMonth; //開花開始
    private Integer endMonth; //開花終了
    
}
