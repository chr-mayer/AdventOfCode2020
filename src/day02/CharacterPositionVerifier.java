package day02;

public class CharacterPositionVerifier {
    public boolean verify(int position, String character, String word) {
        int length = word.length();
        if (position > length) {
            return false;
        }
        return (word.substring(position - 1, position).equals(character));
    }
}
