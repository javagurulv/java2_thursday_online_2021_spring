package lv.javaguru.java2.hrsystem.core.requests;

public class AddEmployeeWithTitleRequest {
    private String name;
    private String lastName;
    private int age;
    private String title;

    public AddEmployeeWithTitleRequest() {
    }

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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}