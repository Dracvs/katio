package edu.eafit.katio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.models.User;
import edu.eafit.katio.repository.UserRepository;
import edu.eafit.katio.services.UserService;

@RestController
@RequestMapping("/katio/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private JwtService jwtService;

    // @Autowired
    // private AuthenticationManager authenticationManager;
    
    @GetMapping("/getall")
    public ResponseEntity<Iterable<User>> getAllUsers(){
        
        var users = new UserService(userRepository).getAllUsers();
        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){

        var createdUser = new UserService(userRepository).addUser(user);        

        // Operador Ternario ?:
        return createdUser.getId() == 0 ? new ResponseEntity<User>(createdUser, HttpStatus.BAD_REQUEST) :
            new ResponseEntity<User>(createdUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    public String autehnticationToken(){//@RequestBody AuthRequest authRequest){
        //Authentication authentication = authenticationManager.Authenticate(new UserNamePasso)
        return "";
    }

    /**
     * Buscar Usuario por nombre
     * Buscar usuario por ID
     * buscar usuario por cedula
     * Buscar usuario por correo
     * Post Login
     * Editar un Usuario
     * Registrar un nuevo usuario
     * BLoquear un Usuario
     * Cambio de Clave (acción combinada)
     * 
     * 
     */
}    
