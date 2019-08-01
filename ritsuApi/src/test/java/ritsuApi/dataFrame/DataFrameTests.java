package ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.dataFrame.DataFrame;
import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import org.junit.jupiter.api.Test;

public class DataFrameTests {

    @Test
    public void testFrameCanRunOneNode(){
        DataFrame underTest = new DataFrame();
        underTest.process(new EngineContext());
    }

    @Test
    public void testRunningDataFrameDoesntChangeStructure(){

    }
}