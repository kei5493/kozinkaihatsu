
package com.kozinkaihatsu.app.Form;

import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;

import lombok.Data;

@Data
public class FlowerSearchForm {
    private Integer colorId; // 色ID（検索条件）


public void giveFlowerSearchForm(FlowerSearchFormDTO dto) {
    this.colorId = dto.getColorId();
}
}