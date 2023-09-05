public class Formatter {
    public static String formatAmount(double amount) {
        int rubles = (int) amount;
        int kopecks = (int) ((amount - rubles) * 100);

        String rublesWord = chooseRublesWord(rubles);

        if (kopecks == 0) {
            return rubles + " " + rublesWord;
        } else if (kopecks < 10) {
            return rubles + "." + "0" + kopecks + " " + rublesWord;
        } else {
            return rubles + "." + kopecks + " " + rublesWord;
        }
    }
    private static String chooseRublesWord(int rubles) {
        int lastDigit = rubles % 10;
        int penultimateDigit = (rubles / 10) % 10;

        if (penultimateDigit == 1 || lastDigit == 0 || (lastDigit >= 5 && lastDigit <= 9)) {
            return "рублей";
        } else if (lastDigit == 1) {
            return "рубль";
        } else {
            return "рубля";
        }
    }
}