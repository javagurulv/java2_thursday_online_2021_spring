package lv.javaguru.java2.hrsystem.core.requests;

public class AddEmployeeTitleRequest {
    private String title;
    private String description;

    public AddEmployeeTitleRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public AddEmployeeTitleRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}