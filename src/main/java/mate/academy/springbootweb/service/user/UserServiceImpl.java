package mate.academy.springbootweb.service.user;

import lombok.RequiredArgsConstructor;
import mate.academy.springbootweb.dto.user.UserRegistrationRequestDto;
import mate.academy.springbootweb.dto.user.UserResponseDto;
import mate.academy.springbootweb.exception.RegistrationException;
import mate.academy.springbootweb.mapper.UserMapper;
import mate.academy.springbootweb.model.User;
import mate.academy.springbootweb.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {

        String email = requestDto.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RegistrationException("User with email: " + email + " already exists");
        }

        User savedUser = new User();
        savedUser.setEmail(email);
        savedUser.setPassword(requestDto.getPassword());
        savedUser.setFirstName(requestDto.getFirstName());
        savedUser.setLastName(requestDto.getLastName());
        savedUser.setShippingAddress(requestDto.getShippingAddress());

        return userMapper.toUserResponseDto(userRepository.save(savedUser));
    }
}
