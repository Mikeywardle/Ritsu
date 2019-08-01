package com.accenture.ritsu.ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.common.SetType;
import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import lombok.Data;

import java.io.Serializable;

@Data
public class MappingNode implements INode, Serializable {

    private INode next;
    private String pathToSet;
    private String valueToSet;
    private SetType setType;

    @Override
    public INode processNext(EngineContext context) {
        return null;
    }
}
