package lv.javaguru.java2.hrsystem.core.databaseImpl;

import lv.javaguru.java2.hrsystem.core.database.DatabaseImpl;
import lv.javaguru.java2.hrsystem.domain.Admin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class loginAdmImplTest {

    @Test
    public void loginAdmTest() {

        DatabaseImpl database = new DatabaseImpl();

        Admin objectOne = new Admin("Alex", "Med", "alexmed@gmail.com", "qwert123");
        Admin objectTwo = new Admin("Max", "Lem", "maxlim@", "qwert123456");

        database.registrationAdm(objectOne);
        database.registrationAdm(objectTwo);

        List<Boolean> actual = new ArrayList<>();
        actual.add(true);
        actual.add(true);

        List<Boolean> expected = new ArrayList<>();

        expected.add(database.loginAdm("alexmed@gmail.com", "qwert123"));
        expected.add(database.loginAdm("maxlim@", "qwert123456"));

        assertEquals(expected, actual);

    }
}
