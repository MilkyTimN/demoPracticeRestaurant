package com.example.demoPractice.model.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreateRequest {

    @NotNull(message = "Имя не должен быть null")
    @Size(min = 3, max = 30, message = "Несоотвестиве кол-во символов, должно быть 3-30")
    String name;

    @NotNull(message = "Пароль не должен быть null")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$", message = "Password must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.")
    String password;

    @Min(value = 18, message = "Возраст должен быть более 18")
    int age;

    @NotNull(message = "Возраст не должен быть null")
    @Email(message = "Это не email")
    String email;

}
