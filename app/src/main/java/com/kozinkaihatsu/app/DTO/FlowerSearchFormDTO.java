package com.kozinkaihatsu.app.DTO;

import lombok.*;
import java.util.List;

import com.kozinkaihatsu.app.Record.FlowerColorRecord;
import com.kozinkaihatsu.app.Record.FlowerNameRecord;

/**
 * 花の詳細表示・登録編集用DTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowerSearchFormDTO {
        // プルダウンの時は、何を選択したかをもたせる
        private List<FlowerColorRecord> flowerColorRecords; //花の色
        private Integer selectedColor; //色（選択済み）

        private List<FlowerNameRecord> flowerNameRecords; //花の名称
        private Integer selectedFlowerName; //花名称（選択済み）
        private String flowerNameForm;        // 花言葉（直接）

        // 花言葉直接入力
         private String languageForm;        // 花言葉（直接）

         private List<Integer> startMonths; // 開花開始月候補
         private List<Integer> endMonths;   // 開花終了月候補
         private Integer selectedStartMonth;
         private Integer selectedEndMonth;
}
