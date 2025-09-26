package com.kozinkaihatsu.app.Record;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FlowerLanguageJoinRecord {
    private Integer id;
    private Integer languageId;
}