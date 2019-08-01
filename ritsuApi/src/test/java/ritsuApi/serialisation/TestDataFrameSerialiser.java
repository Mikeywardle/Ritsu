package ritsuApi.serialisation;

import com.accenture.ritsu.ritsuApi.dataFrame.DataFrame;
import com.accenture.ritsu.ritsuApi.dataFrame.InitialNode;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TestDataFrameSerialiser {

    public static void main(String[] args) {
        DataFrame toSerialise = GenerateDataFrame();
        Serialize(toSerialise);
    }

    private static void Serialize(DataFrame toSerialise) {

        try {
            FileOutputStream file = new FileOutputStream("./ritsuApi/src/test/resources/serialisation_test.ritsu");
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object

            out.writeObject(toSerialise);

            out.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static DataFrame GenerateDataFrame() {

        InitialNode initialNode = new InitialNode();
        DataFrame dataFrame = new DataFrame(initialNode);
        return dataFrame;
    }

}
