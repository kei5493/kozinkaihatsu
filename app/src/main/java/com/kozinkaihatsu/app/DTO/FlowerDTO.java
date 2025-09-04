package com.kozinkaihatsu.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 花の詳細表示・登録編集用DTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowerDTO {
    private Integer id;            // 花ID
    private Integer flowerNameId;  // 花の名前ID
    private String flowerName;     // 花の名前
    private Integer colorId;       // 色ID
    private String colorName;      // 色名
}
