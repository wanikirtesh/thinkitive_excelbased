package com.thinkitive.excelbased.entity;

import lombok.Data;

@Data
public class Step {
    String stepName,action,selector,data;
    boolean expected = true;

    public Step(String stepName, String action, String selector, String data, String expected) {
        this.stepName = stepName;
        this.action = action;
        this.selector = selector;
        this.data = data;
        if(!expected.isBlank()) {
            this.expected = Boolean.parseBoolean(expected);
        }
    }
}
