package lv.javaguru.java2.hrsystem.core.services;

import lv.javaguru.java2.hrsystem.core.database.EmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.GetAllTitlesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllTitlesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTitlesService {

    @Autowired
    private EmployeeTitleRepository employeeTitleRepository;

    public GetAllTitlesResponse execute(GetAllTitlesRequest request) {
        List<EmployeeTitle> titles = employeeTitleRepository.getAllUniqueTitles();
        return new GetAllTitlesResponse(titles);
    }
}