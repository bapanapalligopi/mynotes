package MYNOTES.MyNotes.dtos;

import MYNOTES.MyNotes.models.Notes;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNotesRequest
{
    @NotBlank
    private String notesTitle;
    @NotBlank
    private String notesDescription;
    @NotBlank
    private String user;

    public Notes toNotes()
    {
        return Notes.builder()
                .notesTitle(this.notesTitle)
                .notesDescription(this.notesDescription)
                .build();
    }
}
