package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> getUniqueChars(String word) {

        if (word == null) {
            throw new IllegalArgumentException("Text is null.");
        }
        char[] wordAsChars = word.toCharArray();

        List<Character> result = new ArrayList<>();
        StringBuilder control = new StringBuilder();

        for (char C : wordAsChars
        ) {

            if (!result.contains(C))
            result.add(C);
        }
        return result;
    }
}
