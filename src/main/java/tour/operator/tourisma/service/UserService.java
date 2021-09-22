package tour.operator.tourisma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tour.operator.tourisma.model.user.User;
import tour.operator.tourisma.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAllUsers() {
        
        return userRepository.findAll();
    }
    
    public User findUserById(Integer id) {
        
        return userRepository.findUserById(id);
    }
    
    public void saveUser(User user) {
        
        userRepository.save(user);
    }
    
    public void deleteUser(User user) {
        
        userRepository.delete(user);
    }
    
    public void userUpdate(Integer id, User user) {
        
        User u = userRepository.findUserById(id);
        u.setBirthDate(user.getBirthDate());
        u.setUsername(user.getUsername());
        u.setLastName(user.getLastName());
        saveUser(u);
    }
    
    
}
