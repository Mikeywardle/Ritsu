package com.accenture.ritsu.ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import lombok.Data;

import java.io.Serializable;

@Data
public class InitialNode implements INode, Serializable {

    private INode next;

    public InitialNode(INode next){
        this.next=next;
    }
    public InitialNode(){}

    @Override
    public INode processNext(EngineContext context) {
        return next;
    }
}
