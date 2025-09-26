package com.kozinkaihatsu.app.Form;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.kozinkaihatsu.app.DTO.FlowerRegisterDTO;

import lombok.Data;

@Component
@Data
public class FlowerForm {
    // 色（プルダウン選択 or 新規入力）
    private Integer colorId;       // プルダウン選択
    private String colorName;      // 新規入力
    // 花名（プルダウン選択 or 新規入力）
    private Integer flowerNameId;  // プルダウン選択
    private String flowerName;     // 新規入力
    // 花言葉（カンマ区切りなど）
    private String language;
    // 開花時期
    private Integer startMonth;
    private Integer endMonth;
    // 画像ファイル名
    private MultipartFile imageFile; 
    
    // 登録DTOに反映するメソッド
    public void giveFlowerRegisterDTO(FlowerRegisterDTO dto) {
        dto.setColorId(this.colorId);
        dto.setColorName(this.colorName);
        dto.setFlowerNameId(this.flowerNameId);
        dto.setFlowerName(this.flowerName);
        dto.setLanguage(this.language);
        dto.setStartMonth(this.startMonth);
        dto.setEndMonth(this.endMonth);
        dto.setImageFile(this.imageFile);
}
}