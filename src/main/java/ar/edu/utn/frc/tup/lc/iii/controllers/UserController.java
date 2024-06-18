package ar.edu.utn.frc.tup.lc.iii.controllers;

import ar.edu.utn.frc.tup.lc.iii.dtos.DummyDto;
import ar.edu.utn.frc.tup.lc.iii.dtos.UserDto;
import ar.edu.utn.frc.tup.lc.iii.models.Dummy;
import ar.edu.utn.frc.tup.lc.iii.models.UserModel;
import ar.edu.utn.frc.tup.lc.iii.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserModel user = userService.createUser(userDto.getUserName(), userDto.getEmail());
        UserDto userDtoCreated = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok(userDtoCreated);
    }
}
