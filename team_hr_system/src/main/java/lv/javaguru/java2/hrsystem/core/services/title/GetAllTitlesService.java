package lv.javaguru.java2.hrsystem.core.services.title;

import lv.javaguru.java2.hrsystem.core.database.ORMEmployeeTitleRepository;
import lv.javaguru.java2.hrsystem.core.domain.EmployeeTitle;
import lv.javaguru.java2.hrsystem.core.requests.GetAllTitlesRequest;
import lv.javaguru.java2.hrsystem.core.responses.GetAllTitlesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAllTitlesService {

    @Autowired
  //  private EmployeeTitleRepository employeeTitleRepository;
    private ORMEmployeeTitleRepository ormEmployeeTitleRepository;

    public GetAllTitlesResponse execute(GetAllTitlesRequest request) {
        List<EmployeeTitle> titles = ormEmployeeTitleRepository.getAllUniqueTitles();
        return new GetAllTitlesResponse(titles);
    }
}