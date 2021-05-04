package lv.javaguru.java2.hardcore;

import lv.javaguru.java2.hardcore.consoleUI.ExitUiAction;
import lv.javaguru.java2.hardcore.consoleUI.bet.AddBetUIAction;
import lv.javaguru.java2.hardcore.consoleUI.bet.RemoveBetUIAction;
import lv.javaguru.java2.hardcore.consoleUI.bet.ShowAllBetsUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.AddLotUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.GetAllLotsUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.RemoveLotUIAction;
import lv.javaguru.java2.hardcore.consoleUI.lot.SearchLotByNameOrPriceUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.AddUserUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.LoginUIAction;
import lv.javaguru.java2.hardcore.consoleUI.user.ShowAllUsersUIAction;
import lv.javaguru.java2.hardcore.database.*;
import lv.javaguru.java2.hardcore.services.bet.*;
import lv.javaguru.java2.hardcore.services.lot.*;
import lv.javaguru.java2.hardcore.services.user.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class,Object> beans = new HashMap<>();

    public ApplicationContext(){

        beans.put(LotDatabase.class,new InMemoryLotDatabase());
        beans.put(UserDatabase.class,new InMemoryUserDatabase());
        beans.put(BetDatabase.class,new InMemoryBetDatabase());

        beans.put(AddLotValidator.class,new AddLotValidator());
        beans.put(RemoveLotValidator.class,new RemoveLotValidator());
        beans.put(AddUserValidator.class,new AddUserValidator());
        beans.put(LoginValidator.class,new LoginValidator());
        beans.put(AddBetValidator.class,new AddBetValidator());
        beans.put(RemoveBetValidator.class,new RemoveBetValidator());
        beans.put(SearchLotByNameOrPriceRequestValidator.class,new SearchLotByNameOrPriceRequestValidator());

        beans.put(AddLotService.class,new AddLotService(
                getBean(LotDatabase.class),
                getBean(AddLotValidator.class),
                getBean(LoginService.class)));

        beans.put(RemoveLotService.class,new RemoveLotService(
                getBean(LotDatabase.class),
                getBean(RemoveLotValidator.class)));

        beans.put(AddUserService.class,new AddUserService(
                getBean(UserDatabase.class),
                getBean(AddUserValidator.class)));

        beans.put(LoginService.class,new LoginService(
                getBean(UserDatabase.class),
                getBean(LoginValidator.class)));

        beans.put(AddBetService.class,new AddBetService(
                getBean(BetDatabase.class),
                getBean(AddBetValidator.class),
                getBean(LoginService.class)));

        beans.put(GetAllLotsService.class,new GetAllLotsService(
                getBean(LotDatabase.class)));

        beans.put(ShowAllBetsService.class,new ShowAllBetsService(
                getBean(BetDatabase.class)));

        beans.put(ShowAllUsersService.class,new ShowAllUsersService(
                getBean(UserDatabase.class)));

        beans.put(RemoveBetService.class,new RemoveBetService(
                getBean(BetDatabase.class),
                getBean(RemoveBetValidator.class)));

        beans.put(SearchLotByNameOrPriceService.class,new SearchLotByNameOrPriceService(
                getBean(LotDatabase.class),
                getBean(SearchLotByNameOrPriceRequestValidator.class)));

        beans.put(AddBetUIAction.class,new AddBetUIAction(getBean(AddBetService.class)));
        beans.put(AddLotUIAction.class,new AddLotUIAction(getBean(AddLotService.class)));
        beans.put(AddUserUIAction.class,new AddUserUIAction(getBean(AddUserService.class)));
        beans.put(RemoveBetUIAction.class,new RemoveBetUIAction(getBean(RemoveBetService.class)));
        beans.put(RemoveLotUIAction.class,new RemoveLotUIAction(getBean(RemoveLotService.class)));
        beans.put(ShowAllBetsUIAction.class,new ShowAllBetsUIAction(getBean(ShowAllBetsService.class)));
        beans.put(GetAllLotsUIAction.class,new GetAllLotsUIAction(getBean(GetAllLotsService.class)));
        beans.put(ShowAllUsersUIAction.class,new ShowAllUsersUIAction(getBean(ShowAllUsersService.class)));
        beans.put(LoginUIAction.class,new LoginUIAction(getBean(LoginService.class)));
        beans.put(SearchLotByNameOrPriceUIAction.class,new SearchLotByNameOrPriceUIAction(getBean(SearchLotByNameOrPriceService.class)));
        beans.put(ExitUiAction.class,new ExitUiAction());

    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
