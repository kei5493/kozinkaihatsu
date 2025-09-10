package com.kozinkaihatsu.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kozinkaihatsu.app.DTO.FlowerSearchFormDTO;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.service.FlowerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class FlowerController {

    private final FlowerService flowerService;

    /**
     * 初期表示（GETリクエスト）
     */
    @GetMapping("/")
    public String flowerSearchGet(Model model, @ModelAttribute FlowerSearchForm flowerSearchForm) {
        System.out.println("検索用 花言葉: " + flowerSearchForm.getLanguageForm());


        // キャッシュされた検索フォーム用データ（色・名称などの選択肢）
        FlowerSearchFormDTO flowerSearchFormDTO = flowerService.getSearchFormDTO();
        model.addAttribute("flowerSearchFormDTO", flowerSearchFormDTO);

        // 入力値（form）をキャッシュDTOに反映
        flowerSearchFormDTO = flowerService.giveSearchFormDTO(flowerSearchForm, flowerSearchFormDTO);

        // 検索結果（初期表示は全件）
        List<FlowersListDTO> flowersListDTO = flowerService.flowersListDTO(flowerSearchForm);
        model.addAttribute("flowersListDTO", flowersListDTO);

        // 検索フォーム保持用
        model.addAttribute("flowerSearchForm", flowerSearchForm);

        return "index";
    }

    /**
     * 検索ボタン押下時（POSTリクエスト）
     */
    @PostMapping("/")
    public String flowerSearchPost(@ModelAttribute FlowerSearchForm flowerSearchForm, Model model) {

        // キャッシュ済み検索フォームデータを取得
        FlowerSearchFormDTO flowerSearchFormDTO = flowerService.getSearchFormDTO();

        // 入力値をキャッシュDTOに反映
        flowerSearchFormDTO = flowerService.giveSearchFormDTO(flowerSearchForm, flowerSearchFormDTO);

        // 検索結果
        List<FlowersListDTO> flowersListDTO = flowerService.flowersListDTO(flowerSearchForm);
        model.addAttribute("flowersListDTO", flowersListDTO);

        // 検索フォーム保持用
        model.addAttribute("flowerSearchFormDTO", flowerSearchFormDTO);
        model.addAttribute("flowerSearchForm", flowerSearchForm);

        return "index";
    }
}