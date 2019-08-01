package com.accenture.ritsu.ritsuApi.engine;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class EngineContext {

    private Map<String, Object> context = new HashMap<>();
    private Map<String, Object> variables= new HashMap<>();


    public void add(String string, Object object){
        context.put(string, object);
    }

    public Object get(String string){
        return context.get(string);
    }

    public void addVariable(String string, Object object){
        variables.put(string, object);
    }

    public Object getVariable(String string){
        return variables.get(string);
    }

}
