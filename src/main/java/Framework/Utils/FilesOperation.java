package Framework.Utils;

import java.io.*;
import java.util.Properties;

public class FilesOperation {
    private static final String DIR_PATH_PROPERTIES =
            System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + File.separator +
                    "resources" + File.separator + "Properties" + File.separator;

    public String getProperties(String filename, String properties) {

        try (InputStream input = new FileInputStream(filename)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(properties);
        } catch (IOException e) {
            System.out.println("Arquivo de propriedades não foi encontrado...");
            e.printStackTrace();
        }
        return null;
    }
}

