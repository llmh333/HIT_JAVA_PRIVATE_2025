# Bài tập về nhà buổi 6
## DEADLINE: 24/11/2025

---
### Bài tập: Thiết kế sơ đồ sau:
![](https://uml.planttext.com/plantuml/png/rLCzJmCn3DtpApAXG-Z-G96gVWoe2mYrOayJzpZg9YLn2YVWl-EaKNid61Ywi5mkp_Qp_UnC0YbFSOT2emf1pfpRoWyXPIrRCvA1V6kRVAMM40Q8YlJi_03Q-rQpat5nZP2HrwWiXtOZsLfAI5tpzqREdUMugCdvVBy38l3oIYxpJyPC6_QekeNTkEhwLdo9KkGAtgbNQ8Zh5z3KB-G2IUxT0R1aQC1wk1W_2m5-epImsjwxDyLQbKHhvn2KvJCPAlOy2SYnUIeCDK3JWsen1JuMyv7xJBr80Yt17tWWXLmPay0gIyUPjeMIwH8qwnQcMkOMUVPdsnGncSEicok2nlckUiY2IrtknTS00i5VgAe2QOKw8hEi72byKXXXC8D-4ulT7lzX8xd6kluSzuOzahp0O4qGuhJAnSLjpyRZ1lvY43zqgUlnG2n-RGp33lZDYGa7fHV-3G00)

- Yêu cầu:
  - Tổ chức theo package model, service, service.impl, constant
  - Hàm `calculateTotalValue` là tính toán tổng giá trị của thư viện (số lượng sách * giá thuê)
  - Hàm `getAllBooksByCategory()` là lấy ra tất cả các quyển sách có thể loại là `TextBook` hoặc `Novel` (gợi ý sử dụng instanceof)
  - Hiển thị menu: 
```text
--- Menu ---
1. Thêm sách
2. Lấy sách theo ID
3. Lấy tất cả sách theo thể loại (TextBook/Novel)
4. Lấy tất cả sách
5. Xóa sách theo ID
6. Tổng giá trị thư viện 
```