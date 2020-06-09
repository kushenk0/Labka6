public class Rose extends Flowers{

    public Rose(){
        super();
        set_nameFlower("Роза");
    }

    public Rose(int f, double l, int p){
        super(f, l, p);
        set_nameFlower("Роза");
    }

    @Override ///Перевизначений метод класу Flower
    public int bouquet_total_price (){
        int total_price = get_price();
        return total_price;
    }

}
