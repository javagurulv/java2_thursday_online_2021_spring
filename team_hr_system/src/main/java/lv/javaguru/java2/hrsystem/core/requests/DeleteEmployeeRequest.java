package lv.javaguru.java2.hrsystem.core.requests;

public class DeleteEmployeeRequest {
    private Long id;

    public DeleteEmployeeRequest() {
    }

    public DeleteEmployeeRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}