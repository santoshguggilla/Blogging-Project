package com.example.mct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mct.dto.SignInInput;
import com.example.mct.dto.SignInOutput;
import com.example.mct.dto.SignUpOutput;
import com.example.mct.model.User;
import com.example.mct.service.TokenService;
import com.example.mct.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }
    
    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String email , @RequestParam String token){
        HttpStatus status;
        String msg=null;

        if(tokenService.authenticate(email,token))
        {
            tokenService.deleteToken(token);
            msg = "Signout Successful";
            status = HttpStatus.OK;

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

    @PutMapping()
    public ResponseEntity<String> updateUser(@RequestParam String email , @RequestParam String token , @RequestBody User user){
        HttpStatus status;
        String msg=null;

        if(tokenService.authenticate(email,token))
        {
            try{
                userService.updateUser(user , token);
                status = HttpStatus.OK;
                msg = "User updated sucessfully";
            }catch (Exception e){
                msg = "Enter valid information";
                status = HttpStatus.BAD_REQUEST;
            }

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }
    
    @PostMapping("/follow/{myId}/{otherId}")
    String followUser(@PathVariable Long myId, @PathVariable Long otherId)
    {
        return userService.followUser( myId, otherId);
    }


    

}
