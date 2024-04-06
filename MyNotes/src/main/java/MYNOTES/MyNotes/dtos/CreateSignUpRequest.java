package MYNOTES.MyNotes.dtos;

import MYNOTES.MyNotes.models.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateSignUpRequest
{

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public User toUser()
    {
        return User.builder()
                .username(this.username)
                .password((this.password))
                .build();
    }


}
