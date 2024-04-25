package utils;

import com.codepine.api.testrail.TestRail;

public class TestRailIntegration {
    public static void main(String[] args) {
        String testRailUrl="https://yabluneva.testrail.io/";
        String userName ="victoria_haidei@ukr.net";
        String password ="London24QA__";

        TestRail myTestRail=
                TestRail.builder(testRailUrl,userName,password).applicationName("TestRailIntegration").build();



}}
