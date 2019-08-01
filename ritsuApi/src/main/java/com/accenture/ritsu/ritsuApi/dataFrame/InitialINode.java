package com.accenture.ritsu.ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import lombok.Data;

@Data
public class InitialINode implements INode {

    private INode next;

    public InitialINode(INode next){
        this.next=next;
    }
    public InitialINode(){}

    @Override
    public INode getNext(EngineContext context) {
        return next;
    }
}
