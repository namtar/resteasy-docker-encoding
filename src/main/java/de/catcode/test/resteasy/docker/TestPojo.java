package de.catcode.test.resteasy.docker;

import java.io.Serializable;

public class TestPojo implements Serializable {

    public String testString;

    @Override
    public String toString() {
        return "TestPojo{" +
                "testString='" + testString + '\'' +
                '}';
    }
}
