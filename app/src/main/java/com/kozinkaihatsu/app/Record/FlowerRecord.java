package com.kozinkaihatsu.app.Record;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlowerRecord {
    private Integer id;            // 花ID
    private Integer flowerNameId;  // 花名前ID
    private String flowerName;     // 名称
    private Integer colorId;       // 色ID
    private String colorName;      // 色名
    private Integer startMonth;    // 開花開始月
    private Integer endMonth;      // 開花終了月
    private String imageFileName;  // 画像ファイル名
}
