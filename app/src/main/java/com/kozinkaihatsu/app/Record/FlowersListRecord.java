package com.kozinkaihatsu.app.Record;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * {@code flower.flowerss_list} ビューに対応するRecordクラスです。
 * 花の一覧表示に必要な情報を保持します。
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlowersListRecord {
    private Integer id;
    private String flower_name_id;
    private String flower_name;
    private String color_id;
    private String color_name;
}
