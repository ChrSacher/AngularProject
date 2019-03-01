package BackendSpring.user.service;

import java.util.List;

import BackendSpring.user.domain.User;



public interface UserService
{

    
    public User create(User user);

    
    public User delete(Long id);

    
    public List<User> findAll();

   
    public User findById(Long id);

    
    public User update(User user);
}
