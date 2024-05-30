package edu.eafit.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import edu.eafit.katio.interfaces.BaseUserService;
import edu.eafit.katio.models.User;
import edu.eafit.katio.repository.UserRepository;

public class UserService implements BaseUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> getAllUsers() {
        var userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User addUser(User user) {
        var createdUser = new User();
        
        try{
            if(user.getPasshash().length() > 15)
            {
                user.setPasshash(blake3Formatter(user.getPasshash()));
                createdUser = userRepository.saveAndFlush(user);
                if(createdUser.getId() == 0)
                {
                    createdUser = null;
                }
            }
        }
        catch(Exception ex){
            System.out.println("[ERROR]: {}" + ex.getMessage());
        }
        
        return createdUser;
    }

    public Optional<User> findByEmail(String email)
    {
        return userRepository.findByUserName(email);
    }

    private String blake3Formatter(String value)  throws NoSuchAlgorithmException
    {
        final MessageDigest md = MessageDigest.getInstance("SHA3-512");
        byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hash);
        return sha3Hex;
    }

    private String bytesToHex(byte[] hash){
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length() < 64){
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
}
