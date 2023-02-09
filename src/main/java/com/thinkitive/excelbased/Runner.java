package com.thinkitive.excelbased;

import com.thinkitive.excelbased.entity.Step;
import com.thinkitive.excelbased.entity.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {
        List<Test> tests = parseFile("./testSuite.csv");
        for (Test test : tests) {
            List<Step> steps = test.getSteps();
            for (Step step : steps) {

            }
        }
    }

    private static List<Test> parseFile(String filePath) throws IOException {
        List<String> Lines = Files.readAllLines(Path.of(filePath));
        List<Test> returnList = new ArrayList<>();
        int i=0;
        Test test = null;
        for (String line : Lines) {
            if(i++==0){
                continue;
            }
            String[] cols = line.split(",");
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
