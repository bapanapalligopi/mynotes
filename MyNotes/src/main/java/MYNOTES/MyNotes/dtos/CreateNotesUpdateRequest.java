package MYNOTES.MyNotes.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNotesUpdateRequest {
    @NotBlank
    private String updatedTitle;
    @NotBlank
    private String updatedDescription;
}
