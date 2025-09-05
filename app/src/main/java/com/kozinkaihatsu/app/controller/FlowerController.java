package com.kozinkaihatsu.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Form.FlowerSearchForm;
import com.kozinkaihatsu.app.Record.FlowerColorRecord;
import com.kozinkaihatsu.app.service.FlowerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class FlowerController {

    private final FlowerService flowerService;

    /**
     * 初期表示（GETリクエスト）
     */
    @GetMapping("/flower")
    public String flowerSearchGet(@ModelAttribute FlowerSearchForm flowerSearchForm, Model model) {

        // ① 検索フォーム用データ（色プルダウン）
        List<FlowerColorRecord> colorList = flowerService.getAllFlowerColor();
        model.addAttribute("colorList", colorList);

        // ② 検索結果（初期表示は全件）
        List<FlowersListDTO> flowers = flowerService.findAllFlower();
        model.addAttribute("flowers", flowers);

        // ③ 検索フォーム（選択保持用）
        model.addAttribute("flowerSearchForm", flowerSearchForm);

        return "flower/index"; // ThymeleafのHTML名
    }

    /**
     * 検索ボタン押下時（POSTリクエスト）
     */
    @PostMapping("/")
    public String flowerSearchPost(@ModelAttribute FlowerSearchForm flowerSearchForm, Model model) {

        // ① 検索フォーム用データ（色プルダウン）
        List<FlowerColorRecord> colorList = flowerService.getAllFlowerColor();
        model.addAttribute("colorList", colorList);

        // ② 入力条件に応じて検索
        List<FlowersListDTO> flowers;
        if (flowerSearchForm.getColorId() != null) {
            flowers = flowerService.findFlowerColor(flowerSearchForm);
        } else {
            flowers = flowerService.findAllFlower();
        }
        model.addAttribute("flowers", flowers);

        // ③ 検索フォーム（選択保持用）
        model.addAttribute("flowerSearchForm", flowerSearchForm);

        return "flower/index"; // 検索結果を同じ画面に返す
    }
}