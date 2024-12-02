package com.example.demo.product.dto;

import com.example.demo.category.domain.Category;
import com.example.demo.category.domain.SubCategory;
import com.example.demo.category.domain.ThemeCategory;
import com.example.demo.product.domain.Product;
import com.example.demo.util.file.domain.AttachFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDTO {

    private Long pno;             // 상품 번호
    private String pname;          // 상품 이름
    private int price;
    private Long categoryCno;      // 상위 카테고리 ID
    private Long subCategoryScno;  // 하위 카테고리 ID
    private ThemeCategory themeCategory; // 테마 카테고리
    private List<AttachFile> attachFiles; // JH

    // DTO를 엔티티로 변환하는 메서드
    public Product toEntity(Category category, SubCategory subCategory) {
        return Product.builder()
                .pname(this.pname)
                .price(this.price)
                .category(category)
                .subCategory(subCategory)
                .themeCategory(this.themeCategory)
                .attachFiles(this.attachFiles)
                .build();
    }

}