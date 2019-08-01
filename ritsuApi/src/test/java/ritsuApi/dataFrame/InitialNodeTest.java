package ritsuApi.dataFrame;

import com.accenture.ritsu.ritsuApi.dataFrame.InitialNode;
import com.accenture.ritsu.ritsuApi.dataFrame.INode;
import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InitialNodeTest {

    @Test
    public void testReturnsNextNode(){
        INode INode2 = new InitialNode();
        INode INode1 = new InitialNode(INode2);

        assertTrue(INode1.processNext(new EngineContext())== INode2);
    }

    @Test
    public void returnsNullIfNotAssigned(){
        INode INode = new InitialNode();

        assertTrue(INode.processNext(new EngineContext())==null);
    }
}

