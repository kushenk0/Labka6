public class Flowers {
    private int freshness;

    private double length;

    private int price;

    private String name_flower;

    private int MAX_FRESHNESS = 5;

    private double MAX_LENGTH = 100;

    private int MAX_PRICE = 120;

    ///return к-сть днів зберігання квітки
    public int get_freshness(){
        return freshness;
    }

    ///return довжину
    public double get_length(){
        return length;
    }

    ///return ціну
    public int get_price(){
        return price;
    }

    ///return назву квітки
    public String getName_flower(){
        return name_flower;
    }

    ///встановлює свіжість квітки
    public void set_freshness(int f){
        if (f <= MAX_FRESHNESS){
            freshness = f;
        }
    }

    ///встановлює довжину
    public void set_length(double l){
        if (l <= MAX_LENGTH){
            length = l;
        }
    }

    ///встановлює ціну
    public void set_price(int p){
        if (p <= MAX_PRICE){
            price = p;
        }
    }

    public void set_nameFlower(String fl){
        name_flower = fl;
    }

    public Flowers(){   ///конструкотор без параметрів, встановлює значення полівкласу, які ввдедені в конструктор
        freshness = 4;
        length = 33.5;
        price = 122;
        name_flower = "Лілія";
    }
///l-довжина, f-свіжість, p-ціна
    public Flowers(int f, double l, int p){
        if (f <= MAX_FRESHNESS) freshness = f;
        if (l <= MAX_LENGTH) length = l;
        if (p <= MAX_PRICE) price = p;
        name_flower = "Лілія";
    }
    public int bouquet_total_price(){
        return 3;
    }
}
