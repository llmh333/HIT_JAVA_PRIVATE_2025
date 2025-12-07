# Bài tập về nhà buổi 7 

## DEADLINE: 9/12/2025

### Bài tập: Viết chương trình mô phỏng cuộc đua giữa 3 chiếc xe (3 Threads).

- Class Car triển khai Runnable:
  - `name`: String
  - `speed`: double (Giây / 1 km)
Trong phương thức run():
    - Vòng lặp chạy từ 0 đến 30. Mỗi bước lặp tượng trưng cho 1km.
    - Mỗi lần lặp, xe sẽ ngủ (sleep) một khoảng thời gian ngẫu nhiên (từ 100ms đến `speed` ms) để mô phỏng tốc độ khác nhau.

In ra màn hình: [Tên xe]: Đã chạy được x km.

- Yêu cầu Exception:
    - Tạo một ngoại lệ tùy chỉnh tên là BrokenCarException.
    - Trong quá trình chạy, có 10% xác suất xe bị hỏng bất ngờ (sử dụng Random).
    - Nếu xe hỏng, ném BrokenCarException, in ra "Xe `name` bị nổ lốp!" và chấm dứt luồng của xe đó ngay lập tức (xe đó thua cuộc).

Main: Khởi tạo 3 xe và cho đua cùng lúc.