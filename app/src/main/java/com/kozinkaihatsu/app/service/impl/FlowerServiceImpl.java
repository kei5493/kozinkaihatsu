package com.kozinkaihatsu.app.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kozinkaihatsu.app.DTO.FlowerRegisterDTO;
import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Entity.FlowersListEntity;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowerBloomRecord;
import com.kozinkaihatsu.app.Record.FlowerColorRecord;
import com.kozinkaihatsu.app.Record.FlowerLanguageJoinRecord;
import com.kozinkaihatsu.app.Record.FlowerLanguageRecord;
import com.kozinkaihatsu.app.Record.FlowerNameRecord;
import com.kozinkaihatsu.app.Record.FlowerRecord;
import com.kozinkaihatsu.app.Record.FlowersListRecord;
import com.kozinkaihatsu.app.helper.FlowersListConverter;
import com.kozinkaihatsu.app.repository.common.FlowerBloomMapper;
import com.kozinkaihatsu.app.repository.common.FlowerColorMapper;
import com.kozinkaihatsu.app.repository.common.FlowerLanguageJoinMapper;
import com.kozinkaihatsu.app.repository.common.FlowerLanguageMapper;
import com.kozinkaihatsu.app.repository.common.FlowerMapper;
import com.kozinkaihatsu.app.repository.common.FlowerNameMapper;
import com.kozinkaihatsu.app.repository.view.FlowersListMapper;
import com.kozinkaihatsu.app.service.FlowerService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class FlowerServiceImpl implements FlowerService {

    private final FlowersListMapper flowersListMapper;
    private final FlowersListConverter flowersListConverter;
    private final FlowerColorMapper flowerColorMapper;
    private final FlowerNameMapper flowerNameMapper;
    private final FlowerBloomMapper flowerBloomMapper;
    private final FlowerLanguageMapper flowerLanguageMapper;
    private final FlowerLanguageJoinMapper flowerLanguageJoinMapper;
    private final FlowerMapper flowerMapper;


    /**
     * 検索条件に応じた花リストを取得する
     */
    @Override
    public List<FlowersListDTO> flowersListDTO(FlowerSearchForm form) {
        List<FlowersListRecord> records = flowersListMapper.selectSearchList(form);
        List<FlowersListEntity> entities = flowersListConverter.toEntityList(records);
        return flowersListConverter.toDTOList(entities);
    }

    /**
     * 検索画面用 DTO を取得（キャッシュ付き）
     */
    @Cacheable("flowerSearchFormDTO")
    @Override
    public FlowerSearchFormDTO getSearchFormDTO() {
        List<FlowerColorRecord> colorRecords = flowerColorMapper.selectAllFlowerColor();
        List<FlowerNameRecord> nameRecords = flowerNameMapper.selectAllFlowerName();
        List<Integer> months = IntStream.rangeClosed(1, 12)
                                    .boxed()
                                    .toList();

        return FlowerSearchFormDTO.builder()
                .flowerColorRecords(colorRecords)
                .flowerNameRecords(nameRecords)
                .startMonths(months) 
                .endMonths(months)
                .build();
    }

    /**
     * フォームの内容を DTO に反映
     */
    @Override
    public FlowerSearchFormDTO giveSearchFormDTO(FlowerSearchForm form, FlowerSearchFormDTO dto) {
        dto.setSelectedColor(form.getColor());
        dto.setSelectedFlowerName(form.getSelectName());
        dto.setFlowerNameForm(form.getNameForm());
        dto.setLanguageForm(form.getLanguageForm());
        dto.setSelectedStartMonth(form.getStartMonth());
        dto.setSelectedEndMonth(form.getEndMonth());
        return dto;
    }


    @Override
    public void registerFlower(FlowerRegisterDTO dto) {
            // === 花ID処理 ===
    Integer id = dto.getId();
    if (id == null) {
        int newId = flowerMapper.selectMaxId() + 1;
        id = newId;
        dto.setId(id);
    }


        // === 花名処理 ===
        Integer flowerNameId = dto.getFlowerNameId();
        if (flowerNameId == null && StringUtils.hasText(dto.getFlowerName())) {
            // 既存検索
            flowerNameId = flowerNameMapper.selectIdByName(dto.getFlowerName());
            if (flowerNameId == null) {
                // なければ新規追加
                int newId = flowerNameMapper.selectMaxFlowerNameId() + 1;
                FlowerNameRecord newName = FlowerNameRecord.builder()
                        .flowerNameId(newId)
                        .flowerName(dto.getFlowerName())
                        .build();
                flowerNameMapper.insertFlowerName(newName);
                flowerNameId = newId;
            }
        }
        

    // === 色処理 ===
    Integer colorId = dto.getColorId();
if (colorId == null && StringUtils.hasText(dto.getColorName())) {
    colorId = flowerColorMapper.selectIdByName(dto.getColorName());
    if (colorId == null) {
        int newId = flowerColorMapper.selectMaxColorId() + 1;
        FlowerColorRecord newColor = FlowerColorRecord.builder()
                .colorId(newId)
                .colorName(dto.getColorName())
                .build();
        flowerColorMapper.insertFlowerColor(newColor);
        colorId = newId;
    }
}

  
        // === 画像処理 ===
    String imageFileName = null;
    MultipartFile imageFile = dto.getImageFile();
    if (imageFile != null && !imageFile.isEmpty()) {
        try {
            String uploadDir = "/kozinkaihatsu/images/";
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
            String fileName = UUID.randomUUID() + "_" + imageFile.getOriginalFilename();
            Files.copy(imageFile.getInputStream(), uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
            

            imageFileName = fileName;
        } catch (IOException e) {
            throw new RuntimeException("画像保存に失敗しました", e);
        }
    }
        // === 登録レコード作成 ===
    FlowerRecord record = FlowerRecord.builder()
    .id(id)
    .flowerNameId(flowerNameId)
    .flowerName(dto.getFlowerName())
    .colorId(dto.getColorId())
    .colorName(dto.getColorName())
    .startMonth(dto.getStartMonth())
    .endMonth(dto.getEndMonth())
    .imageFileName(imageFileName)   
    .build();

    // flower テーブルに登録
    flowerMapper.insertFlower(record);

    // === 開花時期処理 ===
    if (dto.getStartMonth() != null && dto.getEndMonth() != null) {
        // 既存があれば削除 or UPDATE
        flowerBloomMapper.deleteByFlowerNameId(flowerNameId);
    
        FlowerBloomRecord bloomRecord = FlowerBloomRecord.builder()
                .flowerNameId(flowerNameId)
                .startMonth(dto.getStartMonth())
                .endMonth(dto.getEndMonth())
                .build();
        flowerBloomMapper.insertFlowerBloom(bloomRecord);
    }
    
    // --- 花言葉処理 ---
    List<String> inputLanguage = Arrays.stream(dto.getLanguage().split(","))
    .map(String::trim)
    .filter(s -> !s.isEmpty())
    .toList();

    for (String lang : inputLanguage) {
    // マスタにあるか確認
    Integer langId = flowerLanguageMapper.selectIdByLanguage(lang);
    if (langId == null) {
    // マスタに新規追加
    FlowerLanguageRecord newLang = FlowerLanguageRecord.builder()
    .language(lang)   
    .build();
    flowerLanguageMapper.insert(newLang);
    langId = newLang.getLanguageId();
    }

    // 結合テーブルに紐付け
    FlowerLanguageJoinRecord joinRecord = FlowerLanguageJoinRecord.builder()
    .id(dto.getId())
    .languageId(langId)
    .build();
    flowerLanguageJoinMapper.insert(joinRecord);
    }

    }


    // 新規登録画面でプルダウンに使う花名称リストを取得
    @Override
    public List<FlowerNameRecord> getAllFlowerNames() {
        return flowerNameMapper.selectAllFlowerName();
    }
    // 新規登録画面でプルダウンに使う色リストを取得
    @Override
    public List<FlowerColorRecord> getAllColors() {
        return flowerColorMapper.selectAllFlowerColor();
    }

    @Override
    public List<FlowersListDTO> getAllFlowers() {
        List<FlowersListRecord> records = flowersListMapper.selectAllFlowersList();
        List<FlowersListEntity> entities = flowersListConverter.toEntityList(records);
        return flowersListConverter.toDTOList(entities);
    }
}