package ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.dataFrame.DataFrame;
import com.accenture.ritsu.ritsuApi.dataFrame.InitialNode;
import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataFrameTests {

    @Test
    public void testFrameCanRunOneNode(){
        DataFrame underTest = new DataFrame(new InitialNode());
        underTest.process(new EngineContext());
    }

    @Test
    public void testRunningDataFrameDoesntChangeStructure(){
        InitialNode node2 = new InitialNode();
        InitialNode node1 =new InitialNode(node2);

        DataFrame underTest = new DataFrame(node1);

        underTest.process(new EngineContext());

        assertTrue(underTest.getInital()==node1);
        assertTrue(underTest.getInital().getNext()==node2);
    }
}