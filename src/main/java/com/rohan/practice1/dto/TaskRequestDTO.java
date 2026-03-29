package com.rohan.practice1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter


public class TaskRequestDTO {
    @NotBlank (message = "Title cannot be blank")
    @Size (min = 2, max = 75, message = "Title should be between 2 and 75 characters")
    private String title;

    @NotBlank (message = "Description cannot be blank")
    @Size (min = 5, max = 500, message = "Description should be between 5 and 500 characters")
    private String description;
}
