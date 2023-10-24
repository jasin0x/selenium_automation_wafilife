package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidCredentials")
    public static Object invalidCredentials(){
        Object[][] dataset = {{"alu@gmail.com","sdfsdfsdf","Unknown email address. Check again or try your username."},
                {"mahamudulh7788@gmail.com","fedsfasdf","Error: The password you entered for the email address mahamudulh7788@gmail.com is incorrect. Lost your password?"},
                {"mahsdfsdf@gmail.com","zxcvqwer","Unknown email address. Check again or try your username."},
                {"","zxcvqwer","Error: ইউজার নাম প্রয়োজন"},
                {"mahamudulh7788@gmail.com","","Error: The password field is empty."}};
        return dataset;
    }

}
