package com.kozinkaihatsu.app.Record;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlowerLanguageRecord {
    private Integer languageId;   // 主キー（DB連番）
    private String language;      // 花言葉文字列
}
