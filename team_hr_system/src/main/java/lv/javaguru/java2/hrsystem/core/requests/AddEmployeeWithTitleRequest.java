package lv.javaguru.java2.hrsystem.core.requests;

public class AddEmployeeWithTitleRequest {
    private String name;
    private String lastName;
    private int age;
    private String title;

    public AddEmployeeWithTitleRequest(String name, String lastName, int age, String title) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}