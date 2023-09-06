public class Formatter { // Я и правда забыл им воспользоваться, обрадовался что код без ошибок компилится и забыл =)
    public static String chooseRublesWord(double total) {

        String rubles = String.format("%.2f", total); // Сначала переписал "formatAmount" со "StringBuilder", но отказался в пользу более простого способа

        double iki = Math.floor(total) % 100; // Переписал прошлые условия, так как ловил неверное окончание при сумме "1.nn"
        double bir = Math.floor(total) % 10;
        String currency = " рубл";

        if (bir == 0 || (bir >= 5 && bir <= 9) || (iki >= 10 && iki <= 20)) {
            currency += "ей";
        } else if (bir > 1 && bir < 5) {
            currency += "я";
        } else {
            currency += "ь";
        }
        return rubles + currency;
    }
}

// ༼ つ ◕_◕ ༽つ