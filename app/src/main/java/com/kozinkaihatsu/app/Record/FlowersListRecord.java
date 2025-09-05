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
    private String flowerNameId;
    private String flowerName;
    private String colorId;
    private String colorName;
}
