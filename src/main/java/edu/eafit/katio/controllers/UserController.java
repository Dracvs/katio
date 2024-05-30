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
import edu.eafit.katio.services.AuthenticationService;
import edu.eafit.katio.services.JwtService;
import edu.eafit.katio.services.UserService;

@RestController
@RequestMapping("/katio/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final JwtService _jwtService;
    private final AuthenticationService _authService;

    @Autowired
    private UserRepository userRepository;


    public UserController(JwtService jwtService, AuthenticationService authService){
        _jwtService = jwtService;
        _authService = authService;
    }
    
    @GetMapping("/getall")
    public ResponseEntity<Iterable<User>> getAllUsers(){
        
        var users = new UserService(userRepository).getAllUsers();
        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user){

        var createdUser = new UserService(userRepository).addUser(user);        

        // Operador Ternario ?:
        return createdUser.getId() == 0 ? 
            new ResponseEntity<String>("El usuario no pudo ser creado.\n Revise sus valores de entrada.", HttpStatus.BAD_REQUEST) :
            new ResponseEntity<String>("El usuario ha sido creado correctamente", HttpStatus.OK);
    }

    @PostMapping("/findbyemail")
    public ResponseEntity<?> findByEmail(User user){
        var userObject = new UserService(userRepository).findByEmail(user.getEmail());
        return ResponseEntity.ok(userObject);
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
