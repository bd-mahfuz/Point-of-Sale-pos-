package com.pos;

import com.pos.dto.Address;
import com.pos.dto.User;
import com.pos.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PosApplication.class)
public class UserTest {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testAddUser() throws InitializationError {

        Address address = new Address();
        address.setAddressLine("new Address line");
        address.setCity("Dhaka");
        address.setCountry("Bangladesh");
        address.setState("Merul badda");

        User user = new User();
        user.setFirstName("Abul");
        user.setLastName("Kalam");
        user.setEmail("kalam@gmail.com");
        user.setPhoneNumber("0198323873");
        user.setUserName("kalam");
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode("12345"));
        user.setAddress(address);
        assertEquals("failed to add new User", true, userService.addUser(user));
    }


    @Test
    public void testUpdateUser() {
        User user = userService.getUser(2);
        user.setPassword(passwordEncoder.encode("123"));
        assertEquals("failed to update the user", true, userService.updateUser(user));
    }

    @Test
    public void testDeleteUser() {
        assertEquals("failed to delete the user", true,
                userService.deleteUser(3));
    }

    @Test
    public void testGetAllUser() {
        assertEquals("failed to get all users", 3,
                userService.getAllUser().size());
    }
}
