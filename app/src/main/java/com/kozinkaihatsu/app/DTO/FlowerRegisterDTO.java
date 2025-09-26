package com.kozinkaihatsu.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlowerRegisterDTO {
    private Integer id;
    // 花名
    private Integer flowerNameId;   // プルダウンで選択した場合
    private String flowerName;      // 新規入力した場合
    // 色
    private Integer colorId;        // プルダウンで選択した場合
    private String colorName;       // 新規入力した場合
    // 花言葉
    private String language;       // カンマ区切りで入力
    // 開花時期
    private Integer startMonth;     
    private Integer endMonth;       
    // 画像
    private MultipartFile imageFile;
}
