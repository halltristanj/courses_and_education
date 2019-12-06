package academy.learnprogramming;

public class Main {

    public static void main(String[] args) {
        //                             1         2         3
        //                   0123456789012345678901234567890123456
        String courseName = "Learn C# for Beginners Crash Course";

        int position = -1;

        do {
            position = courseName.toLowerCase().indexOf(" c", position + 1);
//            position = indexOfIgnoreCase(courseName, " c", position + 1);

            if (position != -1) {
                courseName = replaceByIndex(courseName, position, " c".length(),
                        " Java");
                System.out.println(courseName);
            }
        } while (position != -1);

        String fixedString = courseName.replace(" Java", " C");
        System.out.println(fixedString);
    }

    private static String replaceByIndex(String original, int start, int length,
                                         String replacement) {
        String toRemove = original.substring(start, start + length);
        return original.replaceFirst(toRemove, replacement);
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
