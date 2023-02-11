package com.thinkitive.excelbased;

import com.thinkitive.excelbased.entity.Step;
import com.thinkitive.excelbased.entity.Test;
import com.thinkitive.excelbased.helper.Actions;
import com.thinkitive.excelbased.helper.DriverManger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Runner {
    public static void main(String[] args) throws IOException {
        List<Test> tests = parseFile("./testSuite.csv");
        for (Test test : tests) {
            System.out.println("Starting execution of test: " + test.getName());
            boolean testResult = true;
            DriverManger.initDriver();
            List<Step> steps = test.getSteps();
            for (Step step : steps) {
                System.out.println("\tExecuting step:" + step.getStepName());
                Actions actions = Actions.valueOf(step.getAction().toUpperCase());
                if(!actions.perform(step)){
                    testResult = false;
                    System.out.println("\t### test Failed in step" + step.getStepName());
                    break;
                }
            }
            System.out.println("test execution completed with result " + (testResult?"Pass":"Failed"));
        }
        DriverManger.terminateTest();
    }

    private static List<Test> parseFile(String filePath) throws IOException {
        List<String> Lines = Files.readAllLines(Path.of(filePath));
        List<Test> returnList = new ArrayList<>();
        int i=0;
        Test test = null;
        for (String line : Lines) {
            System.out.println("scanning lin number " + i);
            if(i++==0 || line.trim().isEmpty()){
                continue;
            }
            String[] cols = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)",-1);
            if(!cols[0].isBlank()){
                if(i>2) {
                    returnList.add(test);
                }
                test = new Test(cols[0],cols[1],cols[2]);
            }
            test.addStep(new Step(cols[3],cols[4],cols[5],cols[6],cols.length==8?cols[7]:"True"));
        }
        returnList.add(test);
        return returnList;
    }


}
