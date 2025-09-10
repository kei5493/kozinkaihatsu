
package com.kozinkaihatsu.app.Form;

import org.springframework.stereotype.Component;

import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;

import lombok.Data;

@Component
@Data
public class FlowerSearchForm {
    private Integer color; // 色ID（検索条件）
    private Integer selectName; //花名称id
    private String languageForm;      
    private Integer startMonth;   
    private Integer endMonth;



public void giveFlowerSearchForm(FlowerSearchFormDTO dto) {
    this.color = dto.getSelectedColor();
    this.selectName = dto.getSelectedFlowerName();
    this.languageForm = dto.getLanguageForm();
    this.startMonth = dto.getSelectedStartMonth();
    this.endMonth = dto.getSelectedEndMonth();

}
}