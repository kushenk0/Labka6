public class Lily extends Flowers{

    public Lily(){
        super();
        set_nameFlower("Лілія");
    }

    public Lily(int f, double l, int p){
        super(f, l, p);
        set_nameFlower("Лілія");
    }

    @Override ///Перевизначений метод класу Flower
    public int bouquet_total_price(){
        int total_price = get_price();
        return total_price;
    }

}
