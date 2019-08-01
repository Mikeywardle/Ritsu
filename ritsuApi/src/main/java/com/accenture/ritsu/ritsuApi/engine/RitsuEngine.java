package com.accenture.ritsu.ritsuApi.engine;

import com.accenture.ritsu.ritsuApi.dataFrame.DataFrame;
import com.accenture.ritsu.ritsuApi.serialisation.RitsuDAO;
import lombok.Data;

@Data
public class RitsuEngine {

    private DataFrame dataFrame;
    private RitsuDAO dao = new RitsuDAO();

    public RitsuEngine(String filePath){
        //GetRitsuFIleFromPath
    };

    public RitsuEngine(DataFrame dataFrame){
        this.dataFrame=dataFrame;
    }

    public void runRules(EngineContext context){
        dataFrame.process(context);
    }
}
