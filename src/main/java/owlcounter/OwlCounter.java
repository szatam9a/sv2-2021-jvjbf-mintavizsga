package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {
    private List<String> owlsByProvince = new ArrayList<>();

    public void readFromFile(Path path) {
        try {
            owlsByProvince = Files.readAllLines(path);
        } catch (IOException io) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    public int getNumberOfOwls(String province) {
        for (String actual : owlsByProvince
        ) {
            if (actual.contains(province)) {
                String[] result = actual.split("=");
                System.out.println(result);
                return Integer.parseInt(result[1]);

            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");

    }

    public int getNumberOfAllOwls() {
        int result = 0;
        String[] tempDataProcess;

        for (String actual : owlsByProvince
        ) {

            tempDataProcess = actual.split("=");
            result += Integer.parseInt(tempDataProcess[1]);
        }
    return result;
    }

    public List<String> getOwlsByProvince() {
        return owlsByProvince;
    }
}
