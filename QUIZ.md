# Spring Boot MVC - Quiz Kiểm Tra Nhanh

---

### **Câu 1**

Client gửi yêu cầu tính giá sản phẩm sau khi đã áp dụng mã giảm giá. Logic tính toán này nên được đặt ở đâu?

A. Trong `Controller`, vì nó nhận trực tiếp mã giảm giá từ client.
B. Trong `Repository`, tạo một câu query phức tạp để tính toán trong database.
C. Trong `Service`, vì đây là một nghiệp vụ cốt lõi của kinh doanh.
D. Trong `DTO`, tạo một phương thức `getDiscountedPrice()`.

---

### **Câu 2**

Một `Service` cần lấy thông tin của `User` và các `Order` của user đó. Cách làm đúng đắn nhất là gì?

A. `UserService` gọi trực tiếp `OrderRepository`.
B. `UserService` gọi đến `OrderService` để lấy danh sách order.
C. `Controller` gọi `UserService` và `OrderService` rồi tự kết hợp dữ liệu.
D. Tạo một `Repository` mới là `UserOrderRepository` để join 2 bảng lại.

---

### **Câu 3**

Tại sao việc trả về `Entity` trực tiếp cho Client được coi là một "bad practice"?

A. Vì `Entity` có quá nhiều annotation, làm tăng kích thước response.
B. Vì nó làm lộ cấu trúc bên trong của database và có thể chứa các dữ liệu nhạy cảm.
C. Vì `Entity` không thể được chuyển thành JSON.
D. Vì nó làm cho `Controller` phải làm việc nhiều hơn.

---

## **Đáp Án & Giải Thích**

### **Câu 1: Đáp án là C**

> **Giải thích:** Tính toán giảm giá là một *logic nghiệp vụ (business logic)*. `Controller` chỉ nên điều phối. `Repository` chỉ nên lấy dữ liệu thô. `DTO` chỉ để chứa dữ liệu trả về. Nơi duy nhất hợp lý để xử lý logic này là **`Service`**.

### **Câu 2: Đáp án là B**

> **Giải thích:** Mỗi service nên chịu trách nhiệm cho một domain (phạm vi) riêng. `UserService` quản lý user, `OrderService` quản lý order. Để đảm bảo tính đóng gói và tái sử dụng, `UserService` nên "nói chuyện" với `OrderService` (một Bếp trưởng hỏi một Bếp trưởng khác) thay vì nhảy vào kho của thằng khác (`OrderRepository`). Đây gọi là *Service-to-Service communication*.

### **Câu 3: Đáp án là B**

> **Giải thích:** Đây là lý do chính và nguy hiểm nhất. Việc này phá vỡ nguyên tắc *che giấu thông tin (information hiding)*, tạo ra một lỗ hổng bảo mật và làm cho frontend bị phụ thuộc chặt chẽ vào backend database (*tight coupling*). Các đáp án khác đều sai hoặc không phải là lý do cốt lõi.
