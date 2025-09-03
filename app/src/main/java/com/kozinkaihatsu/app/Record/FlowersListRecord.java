package com.kozinkaihatsu.app.Record;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDate;
/**
 * {@code serious_case.serious_cases_list} ビューに対応するRecordクラスです。
 * 重大事案検索画面の一覧表示に必要な情報を保持します。
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowerListRecord {
    private Integer id;
    private Integer flower_name_id;
    private String flower_name;
    private Integer color_name_id;
    private String color_name;
    
}
