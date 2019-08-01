package ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.dataFrame.InitialINode;
import com.accenture.ritsu.ritsuApi.dataFrame.INode;
import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InitialNodeTest {

    @Test
    public void testReturnsNextNode(){
        INode INode2 = new InitialINode();
        INode INode1 = new InitialINode(INode2);

        assertTrue(INode1.getNext(new EngineContext())== INode2);
    }

    @Test
    public void returnsNullIfNotAssigned(){
        INode INode = new InitialINode();

        assertTrue(INode.getNext(new EngineContext())==null);
    }
}

