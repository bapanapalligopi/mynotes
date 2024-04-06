package MYNOTES.MyNotes.models;

import MYNOTES.MyNotes.dtos.UserWrapper;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"notesTitle", "notesCreatedUser_id"})
        }
)
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int notesId;

    @NotBlank
    @Column(nullable = false,unique = true)
    private String notesTitle;
    @NotBlank
    @Lob
    private String notesDescription;
    @CreationTimestamp
    private String NotesCreatedOn;
    @UpdateTimestamp
    private String NotesUpdatedOn;

    @ManyToOne
    @JoinColumn(name = "notesCreatedUser_id", nullable = false)
    @JsonIgnoreProperties("myNotes")
    User notesCreatedUser;
}
