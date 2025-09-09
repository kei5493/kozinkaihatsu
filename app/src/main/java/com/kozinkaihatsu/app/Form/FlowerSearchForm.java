
package com.kozinkaihatsu.app.Form;

import org.springframework.stereotype.Component;

import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;

import lombok.Data;

@Component
@Data
public class FlowerSearchForm {
    private Integer selectedColor; // 色ID（検索条件）
    private Integer selectedFlowerName; //花名称id
    private Integer selectedFlowerLanguage;      
    private Integer selectedStartMonth;   
    private Integer selectedEndMonth;



public void giveFlowerSearchForm(FlowerSearchFormDTO dto) {
    this.selectedColor = dto.getSelectedColor();
    this.selectedFlowerName = dto.getSelectedFlowerName();
    this.selectedFlowerLanguage = dto.getSelectedFlowerLanguage();
    this.selectedStartMonth = dto.getSelectedStartMonth();
    this.selectedEndMonth = dto.getSelectedEndMonth();

}
}