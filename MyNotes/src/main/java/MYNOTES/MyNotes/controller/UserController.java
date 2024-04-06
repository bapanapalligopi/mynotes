package MYNOTES.MyNotes.controller;

import MYNOTES.MyNotes.dtos.CreateSignUpRequest;
import MYNOTES.MyNotes.dtos.UserWrapper;
import MYNOTES.MyNotes.exceptions.UserAlreadyExists;
import MYNOTES.MyNotes.exceptions.UserNotFound;
import MYNOTES.MyNotes.models.User;
import MYNOTES.MyNotes.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    //create a user
    public User signUp(@RequestBody @Valid CreateSignUpRequest createSignUpRequest) throws UserAlreadyExists
    {
        return userService.singUp(createSignUpRequest.toUser());
    }
    @GetMapping("/get")
    public User getUser(@RequestParam  String username) throws UserNotFound
    {
        return userService.getUser(username);
    }

}
