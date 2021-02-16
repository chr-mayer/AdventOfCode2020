package day02;

public class CharacterCounter {
    public int count(String character, String word) {
        int length = word.length();
        int lengthWithoutSearchCharacter = word.replace(character, "").length();
        return length - lengthWithoutSearchCharacter;
    }
}
