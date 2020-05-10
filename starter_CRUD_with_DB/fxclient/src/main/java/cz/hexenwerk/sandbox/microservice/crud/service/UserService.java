package cz.hexenwerk.sandbox.microservice.crud.service;

import cz.hexenwerk.sandbox.microservice.crud.model.User;

public interface UserService
{

    boolean authenticate(String email, String password);

    User findByEmail(String email);

}
