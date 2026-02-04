package com.dave.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity // Đánh dấu đây là bảng trong DB
@Data // Lombok: Tự tạo Getter, Setter, toString...
@AllArgsConstructor // Lombok: Constructor full tham số
@NoArgsConstructor // Lombok: Constructor rỗng (Bắt buộc cho JPA)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String brand;

    // Giá tiền nên dùng BigDecimal để tránh lỗi làm tròn số
    private BigDecimal price;

    private String category;

    // Ngày tháng dùng java.util.Date
    private Date releaseDate;

    private boolean productAvailable;
    private int stockQuantity; // Số lượng tồn kho

    // Sau này sẽ thêm trường ảnh (image) ở đây
}
