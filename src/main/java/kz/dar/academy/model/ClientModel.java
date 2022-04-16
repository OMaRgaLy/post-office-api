package kz.dar.academy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientModel {
    String clientId;
    @NotNull
    String name;
    @NotNull
    String surname;
    @NotNull
    @Email
    String email;
}
