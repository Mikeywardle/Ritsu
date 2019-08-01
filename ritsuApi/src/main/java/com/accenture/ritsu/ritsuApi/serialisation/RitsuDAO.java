package com.accenture.ritsu.ritsuApi.serialisation;

import com.accenture.ritsu.ritsuApi.dataFrame.DataFrame;

import java.io.*;

public class RitsuDAO {

    public void Serialize(DataFrame dataFrame, String path) throws IOException {

            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(dataFrame);

            out.close();
            file.close();
    }

    public DataFrame Deserialize(String path) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(file);

        DataFrame dataFrame = (DataFrame)in.readObject();

        in.close();
        file.close();

        return dataFrame;
    }
}
