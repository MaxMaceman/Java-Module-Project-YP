public class Product { // Вынес из "Calculator"
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        String formattedPrice = Formatter.chooseRublesWord(price);
        return name + " - " + formattedPrice;
    }
}

// ༼ つ ◕_◕ ༽つ