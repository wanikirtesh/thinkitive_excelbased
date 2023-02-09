package com.thinkitive.excelbased.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Test {
    int id;
    String name;
    boolean enabled;
    List<Step> steps;

    public Test(String id, String name, String enable) {
        this.id = Integer.parseInt(id);
        this.enabled=Boolean.parseBoolean(enable);
        this.name = name;
        steps = new ArrayList<>();
    }

    public void addStep(Step step){
        steps.add(step);
    }
}
