package com.accenture.ritsu.ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.engine.EngineContext;

public interface INode {
    INode processNext(EngineContext context);
}
