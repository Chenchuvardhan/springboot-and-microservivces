package in.mtr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mtr.entity.User;
import in.mtr.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
	private UserRepository userRepo;

	@Override
	public int registerUser(User user) {
		// logic
	    Integer id = userRepo.save(user).getId();
	    return id;
	}

	@Override
	public List<User> getUsers() {
		//logic
		List<User> all = userRepo.findAll();
		return all;
	}
	@Override
    public User getUser(int id) {
        Optional<User> optional = userRepo.findById(id);
        if(optional.isPresent())
        	return optional.get();
        	return null;
    }

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
	}
}
