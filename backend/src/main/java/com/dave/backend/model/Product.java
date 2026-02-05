package com.dave.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date releaseDate;

    private boolean productAvailable;
    private int stockQuantity; // Số lượng tồn kho

    // Tên file ảnh (ví dụ: iphone15.jpg)
    private String imageName;

    // Loại file (ví dụ: image/jpeg, image/png)
    private String imageType;

    // Dữ liệu ảnh thực sự (dạng mảng byte). Cần annotation @Lob để báo DB đây là cục dữ liệu to.
    @Lob
    private byte[] imageData;
}
