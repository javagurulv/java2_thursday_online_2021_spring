package lv.javaguru.java2.realestate;

import lv.javaguru.java2.realestate.console_ui.*;
import lv.javaguru.java2.realestate.core.database.Database;
import lv.javaguru.java2.realestate.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.realestate.core.services.*;
import lv.javaguru.java2.realestate.core.services.validators.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private Map<Class, Object> beans = new HashMap<>();

    public ApplicationContext() {
        beans.put(Database.class, new InMemoryDatabaseImpl());

        beans.put(CreateOfferValidator.class, new CreateOfferValidator());
        beans.put(CreateUserValidator.class, new CreateUserValidator());
        beans.put(DeleteUserValidator.class, new DeleteUserValidator());
        beans.put(LogInValidator.class, new LogInValidator());
        beans.put(DeleteOfferValidator.class, new DeleteOfferValidator());
        beans.put(SearchOffersValidator.class, new SearchOffersValidator());

        beans.put(CreateOfferService.class, new CreateOfferService(
                getBean(Database.class),
                getBean(CreateOfferValidator.class)));
        beans.put(CreateUserService.class, new CreateUserService(
                getBean(Database.class),
                getBean(CreateUserValidator.class)));
        beans.put(DeleteUserService.class, new DeleteUserService(
                getBean(Database.class),
                getBean(DeleteUserValidator.class)));
        beans.put(LogInService.class, new LogInService(
                getBean(Database.class),
                getBean(LogInValidator.class)));
        beans.put(DeleteOfferService.class, new DeleteOfferService(
                getBean(Database.class),
                getBean(DeleteOfferValidator.class)));
        beans.put(SearchOffersService.class, new SearchOffersService(
                getBean(Database.class),
                getBean(SearchOffersValidator.class)));

        beans.put(ExitUIAction.class, new ExitUIAction());
        beans.put(CreateUserUIAction.class, new CreateUserUIAction(getBean(CreateUserService.class)));
        beans.put(LogInUIAction.class, new LogInUIAction(getBean(LogInService.class)));
        beans.put(CreateOfferUIAction.class, new CreateOfferUIAction(getBean(CreateOfferService.class)));
        beans.put(GetAllOffersUIAction.class, new GetAllOffersUIAction(getBean(GetAllOffersService.class)));
        beans.put(DeleteOfferUIAction.class, new DeleteOfferUIAction(getBean(DeleteOfferService.class)));
        beans.put(DeleteUserUIAction.class, new DeleteUserUIAction(getBean(DeleteUserService.class)));
        beans.put(SearchOffersUIAction.class, new SearchOffersUIAction(getBean(SearchOffersService.class)));
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
