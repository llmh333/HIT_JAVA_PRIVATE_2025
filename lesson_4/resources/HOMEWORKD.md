# BÀI TẬP VỀ NHÀ BUỔI 4
## DEADLINE 10/11/2025

### Bài tập: Thiết kế chương trình sau

![](https://uml.planttext.com/plantuml/png/dL91QiCm4BmRz0STKseVUt6XfCqX17e8-0MAjKq4ibP8wq98-_UwbfHARKsX5zixcfsPzMhjIJWQ1yqgLlLQUC_t3kNO4x-mYlE6AzboPIWKHWpGyewSCiU0IF2zKvOKclB0EjLFN8dZGSCCDP_FswI_khalwrox_astBZLJ_nQ8m75X9E_cpm0VWPxEExcA-HDxWdVc1MVtznz3Rz2GGwqdlKlW2obJG1lURI8doOn2PvlDyD-970pu2Wlf5-17hMC8_tssPs49RTgd4qEvgDwE1H3N5BgkMufbrbtddN_ytcwORjd-X0PIZ9FmTzkM7n0r29CRVt6lvXaqzoswnL6RvkqXRObLcNbvmAer63bT_Wy0)

Mô tả chi tiết:
- Lớp `Laptop` và `SmartPhone` được kế thừa từ lớp `Product`
- Sử dụng overriding để triển khai chi tiết các phương thức trong mỗi lớp con
- Trong `ProductController`, biến `type` trong phương thức `addProduct` có ý nghĩa như sau:
  - Nếu `type` là `"laptop"` thì sẽ thêm vào 1 đối tượng Laptop
  - Nếu `type` là `"smartphone"` thì sẽ thêm vào 1 đối tượng Smart Phone