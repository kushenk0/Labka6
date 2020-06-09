public class Tulip extends Flowers{

    public Tulip(){
        super();
        set_nameFlower("Тюльпан");
    }

    public Tulip(int f, double l, int p){
        super(f, l, p);
        set_nameFlower("Тюльпан");
    }

    @Override ///Перевизначений метод класу Flower
    public int bouquet_total_price(){
        int total_price = get_price();
        return total_price;
    }

}
