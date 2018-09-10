package br.com.informatica.model;

public class LoginModel {

    public boolean autenticar(String name, String password) {
        return name.equals("admin") && password.equals("admin");
    }

}
