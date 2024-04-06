package MYNOTES.MyNotes.service;

import MYNOTES.MyNotes.dtos.UserWrapper;
import MYNOTES.MyNotes.exceptions.UserAlreadyExists;
import MYNOTES.MyNotes.exceptions.UserNotFound;
import MYNOTES.MyNotes.models.User;
import MYNOTES.MyNotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserWrapper userWrapper;
    public User singUp(User user) throws UserAlreadyExists
    {
        try{
            return userRepository.save(user);
        }
        catch (DataIntegrityViolationException e )
        {
            throw  new UserAlreadyExists("oops! username already exists.");
        }
    }
    public User getUser(String username) throws UserNotFound
    {
        User user=userRepository.findByUsername(username);
        if(user==null) throw  new UserNotFound("Oops!! user not found!!!");
        else  return user;
    }
}
