package MYNOTES.MyNotes.controller;

import MYNOTES.MyNotes.dtos.CreateNotesRequest;
import MYNOTES.MyNotes.dtos.CreateNotesUpdateRequest;
import MYNOTES.MyNotes.dtos.UserWrapper;
import MYNOTES.MyNotes.models.Notes;
import MYNOTES.MyNotes.models.User;
import MYNOTES.MyNotes.service.NotesService;
import MYNOTES.MyNotes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/notes")
public class NotesController {
    @Autowired
    NotesService notesService;
    @Autowired
    UserService userService;
    @PostMapping("/create")
    public Notes create(@RequestBody @Valid CreateNotesRequest createNotesRequest) throws Exception
    {
        User user = userService.getUser(createNotesRequest.getUser());
        Notes notes=createNotesRequest.toNotes();
        user.setMyNotes(asList(notes));
        notes.setNotesCreatedUser(user);

        return  notesService.create(notes);
    }
    @GetMapping("/get")
    public Notes get(@RequestParam  String title) throws Exception
    {
        return notesService.get(title);
    }

    @DeleteMapping("/delete")
    public Notes delete(@RequestParam String title) throws Exception
    {
        return notesService.delete(title);
    }
    @PutMapping("/update")
    public Notes update(@RequestBody CreateNotesUpdateRequest createNotesUpdateRequest,@RequestParam String title) throws Exception
    {
        return notesService.update(createNotesUpdateRequest,title);
    }
}
