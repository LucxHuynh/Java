package com.example.demo.model;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhanvien")  // Tên bảng trong cơ sở dữ liệu
public class NhanVien {
    @Id
    @Column(name = "ma_nv", length = 3, nullable = false)
    private String Ma_NV;

    @Column(name = "ten_nv", length = 100, nullable = false)
    private String Ten_NV;

    @Column(name = "phai", length = 3)
    private String Phai;

    @Column(name = "noisinh", length = 200)
    private String NoiSinh;

    @Column(name = "ma_phong", length = 2)
    private String Ma_Phong;

    @Column(name = "luong")
    private int Luong;

    @ManyToOne
    @JoinColumn(name = "ma_phong", insertable = false, updatable = false)
    private PhongBan phongBan;
}