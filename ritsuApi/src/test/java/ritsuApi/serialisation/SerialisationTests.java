package ritsuApi.serialisation;

import com.accenture.ritsu.ritsuApi.dataFrame.DataFrame;
import com.accenture.ritsu.ritsuApi.dataFrame.InitialNode;
import com.accenture.ritsu.ritsuApi.dataFrame.MappingNode;
import com.accenture.ritsu.ritsuApi.serialisation.RitsuDAO;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SerialisationTests {

    @Test
    public void TestThatFileIsSerialisedInCorrectPlace() throws IOException {
        RitsuDAO underTest =new RitsuDAO();
        DataFrame dataFrame = new DataFrame(new InitialNode());
        String filePath = "/C:/test.ritsu";

        underTest.Serialize(dataFrame,filePath);
        assertTrue(new File(filePath).exists());
    }

    @Test
    public void TestsThatFileCanBeDeserialised() throws IOException, ClassNotFoundException {
        RitsuDAO underTest =new RitsuDAO();
        String filePath = "./src/test/resources/serialisation_test.ritsu";

        DataFrame fromFile = underTest.Deserialize(filePath);

        assertNotNull(fromFile);
        assertEquals(fromFile.getInital(), new InitialNode());
    }

    @Test
    public void TestThatDataIsNotLostWhenSerialising() throws IOException, ClassNotFoundException {
        RitsuDAO underTest =new RitsuDAO();

        MappingNode mappingNode = new MappingNode();
        InitialNode initial = new InitialNode(mappingNode);
        DataFrame dataFrame = new DataFrame(initial);
        String filePath = "/C:/test.ritsu";

        underTest.Serialize(dataFrame,filePath);
        DataFrame fromFile = underTest.Deserialize(filePath);

        assertNotNull(fromFile);
        assertEquals(fromFile.getInital(), initial);
        assertEquals(fromFile.getInital().getNext(), mappingNode);
    }

    @Test
    public void checkThatExceptionIsThrownIfNotDeSerialisedSuccessfully(){
        RitsuDAO underTest =new RitsuDAO();
        String filePath = "someRandomPath";
        String notDataFramePath = "./src/test/resources/not_dataframe.ritsu";

        assertThrows(IOException.class, ()  -> underTest.Deserialize(filePath));
        assertThrows(ClassNotFoundException.class, ()  -> underTest.Deserialize(notDataFramePath));

    }
}
