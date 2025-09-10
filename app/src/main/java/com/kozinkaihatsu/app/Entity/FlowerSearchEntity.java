package com.kozinkaihatsu.app.Entity;

import lombok.Data;

@Data
public class FlowerSearchEntity {

    private Integer colorId; //色id
    private Integer flowerNameId; //花名称id
    private Integer languageId;  
    private String  languages;    
    private Integer startMonth;   
    private Integer endMonth;
}