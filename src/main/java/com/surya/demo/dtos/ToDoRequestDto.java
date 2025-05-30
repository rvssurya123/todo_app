package com.surya.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ToDoRequestDto {
    @NotBlank(message = "Desc cannot be blank")
    private String description;

    @NotNull
    private Integer userId;
}
