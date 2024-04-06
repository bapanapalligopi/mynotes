package MYNOTES.MyNotes.service;

import MYNOTES.MyNotes.dtos.CreateNotesUpdateRequest;
import MYNOTES.MyNotes.exceptions.NotesNotFoundByTitle;
import MYNOTES.MyNotes.models.Notes;
import MYNOTES.MyNotes.models.User;
import MYNOTES.MyNotes.repository.NotesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotesService {
    @Autowired
    NotesRepository notesRepository;
    public Notes create(Notes notes)
    {
        return notesRepository.save(notes);
    }
    public Notes get(String title) throws Exception
    {
        Notes  notes =notesRepository.findByNotesTitle(title);
        if(notes==null) throw  new NotesNotFoundByTitle("oops!! notes not found by title");
        return notes;
    }
    @Transactional
    public Notes delete(String title) throws Exception
    {
        notesRepository.setForeignKeyChecksToZero();
        Notes notes=get(title);
        notesRepository.deleteByNotesTitle(title);
        notesRepository.setForeignKeyChecksToOne();
        return notes;
    }
  public Notes update(CreateNotesUpdateRequest createNotesUpdateRequest,String title) throws Exception
  {
      Notes  notes =notesRepository.findByNotesTitle(title);
      if(notes==null) throw  new NotesNotFoundByTitle("oops!! notes not found by title");
      notes.setNotesUpdatedOn(String.valueOf(System.currentTimeMillis()));
      int id=notes.getNotesId();
      String newTitle=createNotesUpdateRequest.getUpdatedTitle();
      String newDescription=createNotesUpdateRequest.getUpdatedDescription();
      notesRepository.updateByNotesIdAndNotesTitleAndNotesDescription(id,newTitle,newDescription);
      Notes updatedNotes=notesRepository.findByNotesTitle(newTitle);
      return updatedNotes;
  }
}
