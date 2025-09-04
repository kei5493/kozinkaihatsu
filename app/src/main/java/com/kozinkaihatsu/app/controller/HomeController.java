package com.kozinkaihatsu.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.service.FlowerService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class HomeController {
    private final FlowerService flowerService;

    @GetMapping("/")
    public String index(Model model) {
        // 花リストDTOを取得
        List<FlowersListDTO> flowersListDTOs = flowerService.findAllFlower();

        // 画面に渡す
        model.addAttribute("flowersList", flowersListDTOs);

        return "result";
    }
}