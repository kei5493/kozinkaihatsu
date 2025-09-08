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
public class FlowerSearchFormDTO {
    private Integer color;       // 色ID
    private String colorName;  // 色名（画面戻し用）
}
