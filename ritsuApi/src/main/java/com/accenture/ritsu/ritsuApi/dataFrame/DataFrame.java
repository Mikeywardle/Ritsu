package com.accenture.ritsu.ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class DataFrame implements Serializable {
    private INode inital = new InitialINode();

    public void process(EngineContext context){
        run(inital, context);
    }

    private void run(INode INode, EngineContext context){
        INode next = INode.getNext(context);
        if(next==null)
            return;
        run(INode, context);
    }
}
