package MYNOTES.MyNotes.dtos;

import MYNOTES.MyNotes.models.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class UserWrapper
{
    private int id;
    private String username;
    public String createdOn;

    public UserWrapper toUserWrapper(User user)
    {
       return  UserWrapper.builder()
                .id(user.getId())
                .createdOn(user.getCreatedOn())
                .username(user.getUsername())
                .build();
    }
}
