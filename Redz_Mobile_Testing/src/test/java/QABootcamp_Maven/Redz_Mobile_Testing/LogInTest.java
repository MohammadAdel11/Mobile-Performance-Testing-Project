package QABootcamp_Maven.Redz_Mobile_Testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogInTest extends TestBase {
    LogIn login;

    @BeforeMethod
    public void setUpPage() {
        login = new LogIn(driver);
    }

    @Test(dataProvider = "LogInData")
    public void logIn(String userName, String pass) {
        login.Login(userName, pass);
        login.clickLogIn(); 

        if (login.isNextVisible()) {
            Assert.assertTrue(login.isNextVisible(), "Next button should appear on successful login");
            login.clickNext();
            return;
        }

        if (!userName.isEmpty() && !pass.isEmpty()) {
            if (login.isErrorVisible()) {
                String error = login.getMessage();
                Assert.assertTrue(error.contains("Incorrect email, username, or password"),
                        "Error message should contain 'Incorrect email, username, or password'");
                return;
            }
        }

        Assert.assertTrue(login.isStillOnLoginPage(),
                "Should stay on login page when fields are empty or incomplete");
    }

    @DataProvider(name = "LogInData")
    public Object[][] readFile() throws Exception {
        List<Object[]> rows = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader("src/test/resources/LoginData.csv"))) {
            String line;
            boolean firstLine = true;

            while ((line = bf.readLine()) != null) {
                if (firstLine) { // skip header
                    firstLine = false;
                    continue;
                }
                if (line.isBlank()) continue;

                String[] parts = line.split(",", -1);
                String userName = parts[0].trim();
                String password = parts[1].trim();

                rows.add(new Object[]{userName, password});
            }
        }

        return rows.toArray(new Object[0][]);
    }
}
