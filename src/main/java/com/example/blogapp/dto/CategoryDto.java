package com.example.blogapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Integer id;
    @NotBlank
    @Size(min = 3)
    private String categoryTitle;
    @NotBlank
    private String categoryDesc;
}
