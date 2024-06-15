package com.example.demo.controller;

import com.example.demo.model.NhanVien;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping
    public String getAllNhanViens(@RequestParam(defaultValue = "0") int page, Model model) {
        Pageable pageable = PageRequest.of(page, 10); // Mỗi trang có 5 nhân viên
        Page<NhanVien> nhanVienPage = nhanVienService.getAllNhanViens(pageable);
        model.addAttribute("nhanviens", nhanVienPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", nhanVienPage.getTotalPages());
        return "nhanvien/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("nhanvien", new NhanVien());
        return "nhanvien/new";
    }

    @PostMapping
    public String createNhanVien(@ModelAttribute("nhanvien") NhanVien nhanVien) {
        nhanVienService.createNhanVien(nhanVien);
        return "redirect:/nhanviens";
    }

    @GetMapping("/edit/{maNV}")
    public String showEditForm(@PathVariable String maNV, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(maNV)
                .orElseThrow(() -> new RuntimeException("NhanVien not found"));
        model.addAttribute("nhanvien", nhanVien);
        return "nhanvien/edit";
    }

    @PostMapping("/update/{maNV}")
    public String updateNhanVien(@PathVariable String maNV, @ModelAttribute("nhanvien") NhanVien nhanVienDetails) {
        nhanVienService.updateNhanVien(maNV, nhanVienDetails);
        return "redirect:/nhanviens";
    }

    @GetMapping("/delete/{maNV}")
    public String deleteNhanVien(@PathVariable String maNV) {
        nhanVienService.deleteNhanVien(maNV);
        return "redirect:/nhanviens";
    }
}
