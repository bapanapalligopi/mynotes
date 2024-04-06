package MYNOTES.MyNotes.repository;

import MYNOTES.MyNotes.models.Notes;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface NotesRepository  extends JpaRepository<Notes,Integer> {
    @Transactional
    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 0;", nativeQuery = true)
    void setForeignKeyChecksToZero();
    @Transactional
    @Modifying
    @Query(value = "SET FOREIGN_KEY_CHECKS = 1;", nativeQuery = true)
    void setForeignKeyChecksToOne();

    Notes findByNotesTitle(String title);
    void deleteByNotesTitle(String title);

    @Transactional
    @Modifying
    @Query("update Notes set notesTitle = :title, notesDescription = :description where notesId = :id")
    void updateByNotesIdAndNotesTitleAndNotesDescription(int id, String title, String description);
}
