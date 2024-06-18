package ar.edu.utn.frc.tup.lc.iii.services.impl;

import ar.edu.utn.frc.tup.lc.iii.entities.UserEntity;
import ar.edu.utn.frc.tup.lc.iii.models.UserModel;
import ar.edu.utn.frc.tup.lc.iii.repositories.UserRepository;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserModel createUser(String userName, String email) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);
        if (userEntityOptional.isPresent()) {
            //todo: enviar error al usuario
            return null;
        }
        else {
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail(email);
            userEntity.setUserName(userName);
            UserEntity userEntitySaved = userRepository.save(userEntity);
            return modelMapper.map(userEntitySaved, UserModel.class);
        }
    }
}
