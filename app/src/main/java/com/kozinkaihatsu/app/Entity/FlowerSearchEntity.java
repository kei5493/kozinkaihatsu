package com.kozinkaihatsu.app.Entity;

import lombok.Data;

@Data
public class FlowerSearchEntity {

    private Integer flowerNameId; //花名称id
    private String flowerName; //花名称
    private Integer colorId; //色id
    private String languages; //花言葉
    private String flowerLanguageIds; //花言葉id
    private Integer startMonth; //開花開始
    private Integer endMonth; //開花終了
}