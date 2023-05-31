package task3;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomAnnotationsWithBeforeAndAfterMethod {
    private List<String> userList;

    @BeforeMethod
    public void setUp() {

        userList = new ArrayList<>();
        userList.add("Aman");
        userList.add("Pawar");
    }

    @AfterMethod
    public void tearDown() {

        userList.clear();
    }

    @Test
    public void testAddUser() {
        userList.add("Rajat");
        Assert.assertEquals(userList.size(), 3);
        Assert.assertTrue(userList.contains("Rajat"));
    }

    @Test
    public void testRemoveUser() {
        userList.remove("Aman");
        Assert.assertEquals(userList.size(), 1);
        Assert.assertFalse(userList.contains("Aman"));
    }

}
