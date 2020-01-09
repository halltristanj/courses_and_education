package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        StringBuilder courseName = new StringBuilder("Learn C# for Beginners Crash Course");

        int position = -1;

        do {
            position = courseName.toString().toLowerCase().indexOf(" c", position + 1);
//            position = indexOfIgnoreCase(courseName, " c", position + 1);

            if (position != -1) {
                replaceByIndex(courseName, position, " c".length()," Java");
                System.out.println(courseName);
            }
        } while (position != -1);

        String fixedString = courseName.toString().replace(" Java", " C");
        System.out.println(fixedString);
    }

    private static String replaceByIndex(String original, int start, int length,
                                         String replacement) {
        String toRemove = original.substring(start, start + length);
        return original.replaceFirst(toRemove, replacement);
    }

    private static StringBuilder replaceByIndex(StringBuilder original, int start, int length,
                                         String replacement) {
        String toRemove = original.substring(start, start + length);
        return original.replace(start, start + length, replacement);
    }

    private static int indexOfIgnoreCase(String text, String searchText, int fromIndex) {
        return text.toLowerCase().indexOf(searchText.toLowerCase(), fromIndex);
    }
//    private static int indexOfIgnoreCase(String text, String searchText, int fromIndex) {
//        String textLowerCase = text.toLowerCase();
//        String searchTextLowerCase = searchText.toLowerCase();
//        return textLowerCase.indexOf(searchTextLowerCase, fromIndex);
//    }
}
