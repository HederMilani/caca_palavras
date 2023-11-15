public class TextAnalyzer {
    public int countWords(String testString) {
        String[] words = testString.split(" ");
        return words.length;
    }

    public int countCharacters(String testString) {
        return testString.length();
    }

    public int countCharactersExcludingSpaces(String testString) {
        String stringWithoutSpaces = testString.replaceAll(" ", "");
        return stringWithoutSpaces.length();
    }

    public int countWordsWithLength(String testString, int init, int end) {
        String[] words = testString.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.length() >= init && word.length() <= end) {
                count++;
            }
        }
        return count;
    }

    public int countOccurrencesOfLetter(String testString, char letter) {
        int count = 0;
        char lowerCaseLetter = Character.toLowerCase(letter);
        for (char c : testString.toLowerCase().toCharArray()) {
            if (c == lowerCaseLetter) {
                count++;
            }
        }
        return count;
    }

}
