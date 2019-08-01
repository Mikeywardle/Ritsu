package ritsuApi.engine;

import com.accenture.ritsu.ritsuApi.engine.EngineContext;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineContextTest {

    @Test
    public void CanAddObjectToContext(){
        EngineContext context = new EngineContext();
        List<String> strings = new ArrayList<>();
        strings.add("Hello");

        context.add("foo", strings);

        assertTrue(context.get("foo") == strings);

        List<String> fromContext =  (List<String>)context.get("foo");
        assertEquals((fromContext.get(0)), "Hello");
    }

    @Test
    public void CanAddMultipleObjectsToContext(){
        EngineContext context = new EngineContext();
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        List<Integer> integers = new ArrayList<>();
        integers.add(42);

        context.add("foo", strings);
        context.add("bar", integers);

        assertTrue(context.get("foo") == strings);
        assertTrue(context.get("bar") == integers);

        List<String> fromContext =  (List<String>)context.get("foo");
        List<Integer> fromContext2 =  (List<Integer>)context.get("bar");

        assertEquals((fromContext.get(0)), "Hello");
        assertEquals((fromContext2.get(0)), new Integer(42));
    }

    @Test
    public void CanAddVariables(){
        EngineContext context = new EngineContext();
        List<String> strings = new ArrayList<>();
        strings.add("Hello");

        context.addVariable("foo", strings);

        assertTrue(context.getVariable("foo") == strings);

        List<String> fromContext =  (List<String>)context.getVariable("foo");
        assertEquals((fromContext.get(0)), "Hello");
    }

    @Test
    public void CanAddMultipleVariables(){
        EngineContext context = new EngineContext();
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        List<Integer> integers = new ArrayList<>();
        integers.add(42);

        context.addVariable("foo", strings);
        context.addVariable("bar", integers);

        assertTrue(context.getVariable("foo") == strings);
        assertTrue(context.getVariable("bar") == integers);

        List<String> fromContext =  (List<String>)context.getVariable("foo");
        List<Integer> fromContext2 =  (List<Integer>)context.getVariable("bar");

        assertEquals((fromContext.get(0)), "Hello");
        assertEquals((fromContext2.get(0)), Integer.valueOf(42));
    }

}
