package com.kozinkaihatsu.app.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kozinkaihatsu.app.DTO.FlowerRegisterDTO;
import com.kozinkaihatsu.app.DTO.FlowersListDTO;
import com.kozinkaihatsu.app.Form.FlowerForm;
import com.kozinkaihatsu.app.service.FlowerService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class FlowerRegisterController {
    @Autowired
    private FlowerService flowerService;

    // 登録画面表示
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("flowerForm", new FlowerForm());
        model.addAttribute("colorList", flowerService.getAllColors());
        model.addAttribute("flowerNameList", flowerService.getAllFlowerNames());
        model.addAttribute("monthList", IntStream.rangeClosed(1, 12).boxed().toList()); 
        return "register"; 
    }

    // 登録処理
    @PostMapping("/register")
    public String registerFlower(@ModelAttribute FlowerForm flowerForm, Model model, RedirectAttributes redirectAttributes) {
        FlowerRegisterDTO dto = new FlowerRegisterDTO();
        flowerForm.giveFlowerRegisterDTO(dto);
        flowerService.registerFlower(dto);

        redirectAttributes.addFlashAttribute("message", "新規登録が完了しました！");

        return "redirect:/"; // トップ画面にリダイレクト
}
}

