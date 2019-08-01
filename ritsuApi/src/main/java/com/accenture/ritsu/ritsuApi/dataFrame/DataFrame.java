package com.accenture.ritsu.ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class DataFrame implements Serializable {
    private InitialNode inital = new InitialNode();

    public DataFrame(InitialNode inital){this.inital=inital;}

    public void process(EngineContext context){
        run(inital, context);
    }

    private void run(INode INode, EngineContext context){
        INode next = INode.processNext(context);
        if(next==null)
            return;
        run(next, context);
    }
}
