package lv.javaguru.java2.wasterestarant.core.requests.user;

public class RegistrationRequest {
    private String name;
    private String surname;
    private String personal_code;
    private String email;
    private String password;

    public RegistrationRequest(String name, String surname, String personal_code, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.personal_code = personal_code;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonal_code() {
        return personal_code;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
