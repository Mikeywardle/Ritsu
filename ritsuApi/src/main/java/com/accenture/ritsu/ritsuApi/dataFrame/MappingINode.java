package com.accenture.ritsu.ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.common.SetType;
import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import lombok.Data;

@Data
public class MappingINode implements INode {

    private INode next;
    private String pathToSet;
    private String valueToSet;
    private SetType setType;

    @Override
    public INode getNext(EngineContext context) {
        return null;
    }
}
