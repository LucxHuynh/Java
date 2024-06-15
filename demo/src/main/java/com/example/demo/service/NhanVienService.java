package com.example.demo.service;

import com.example.demo.model.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public Page<NhanVien> getAllNhanViens(Pageable pageable) {
        return nhanVienRepository.findAll(pageable);
    }

    public NhanVien createNhanVien(NhanVien nhanVien) {
        return nhanVienRepository.save(nhanVien);
    }

    public NhanVien updateNhanVien(String maNV, NhanVien nhanVienDetails) {
        NhanVien nhanVien = nhanVienRepository.findById(maNV).orElseThrow(() -> new RuntimeException("NhanVien not found"));
        nhanVien.setTen_NV(nhanVienDetails.getTen_NV());
        nhanVien.setPhai(nhanVienDetails.getPhai());
        nhanVien.setNoiSinh(nhanVienDetails.getNoiSinh());
        nhanVien.setMa_Phong(nhanVienDetails.getMa_Phong());
        nhanVien.setLuong(nhanVienDetails.getLuong());
        return nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVien(String maNV) {
        nhanVienRepository.deleteById(maNV);
    }

    public Optional<NhanVien> getNhanVienById(String maNV) {
        return nhanVienRepository.findById(maNV);
    }
}
