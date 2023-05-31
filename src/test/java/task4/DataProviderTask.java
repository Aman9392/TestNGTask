package task4;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderTask {
    @DataProvider(name = "userData")
    public Object[][] userDataProvider() {

        String[][] data = {
                {"Aman", "Pawar", "aman@example.com"},
                {"Rajat", "Soni", "rajat@example.com"},
                {"Abraham", "Phillip", "abraham@example.com"}
        };
        return data;
    }

    @Test(dataProvider = "userData")
    public void testUser(String firstName, String lastName, String email) {
        if(firstName == "Rajat") {
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Performing user-specific test...");
        }
    }
}
