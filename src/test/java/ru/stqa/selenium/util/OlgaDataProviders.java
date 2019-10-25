package ru.stqa.selenium.util;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OlgaDataProviders {
    @DataProvider
    public static Iterator<Object[]> registrationNegative() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                OlgaDataProviders.class.getResourceAsStream("/DRegistrationNegative.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }
}
