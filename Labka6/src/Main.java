/**
 * 9217
 * С13 - 0
 * Визначити ієрархію квітів.
 * Створити кілька об'єктів-квітів.
 * Зібрати букет (використовуючи аксесуари) з визначенням його вартості.
 * Провести сортування квітів у букеті за рівнем свіжості.
 * Знайти квітку в букеті, що відповідає заданому діапазону довжин.
 */
public class Main {
    public static String Parametrs(Flowers f){
        return  f.getName_flower() + " — ціна " + f.get_price() + " грн." + ", свіжість " + f.get_freshness() + " дн." + ", довжина квітки " + f.get_length() + " см" ;
    }
///виводить всі квітки, які в букеті
    public static void output_flowers(Flowers[] bouquet){
        for (int i = 0; i < bouquet.length; i++){
            System.out.println(Parametrs(bouquet[i]));
        }
    }
///пошук за довжиною
    public static Flowers flower_length(Flowers [] bouquet, double length1,double length2){
        Flowers result = bouquet[0];
        for (int i = 0; i < bouquet.length; i++){
            if (bouquet[i].get_length() >= length1 && bouquet[i].get_length() <= length2)
                result = bouquet[i];
        }
        return result;
    }
///сортування квітів
    public static void sort_freshness(Flowers[] bouquet, int k) {
        System.out.println("СОРТУВАННЯ КВІТІВ У БУКЕТІ ЗА РІВНЕМ СВІЖОСТІ:");
        Flowers fresh;
        for (int i = 0; i <= k - 1; i++) {
            for (int j = 0; j <= k - 1; j++) {
                if (bouquet[i].get_freshness() > bouquet[j].get_freshness()) {
                    fresh = bouquet[i];
                    bouquet[i] = bouquet[j];
                    bouquet[j] = fresh;
                }
            }
        }
    }
///сума всіх ківтів
    public static int bouquet_price(Flowers [] bouquet) {
        int total_price = 0;
        for (int i = 0; i < bouquet.length; i++) {
            total_price += bouquet[i].get_price();
        }
        System.out.println("ЗАГАЛЬНА ЦІНА БУКЕТУ СТАНОВИТЬ: " + total_price + " гривень");
        return total_price;
    }

    public static void main(String[] args) {
        final int count = 6;
        Flowers bouquet[] = new Flowers[count];   ///масив квітів
        bouquet[0] = new Rose(3,30.0,60);
        bouquet[1] = new Rose(3,34.0,70);
        bouquet[2] = new Tulip(2,19.0,35);
        bouquet[3] = new Tulip(2,21.2,40);
        bouquet[4] = new Lily(1,32.4,120);
        bouquet[5] = new Lily();

        System.out.println("БУКЕТ:");
        output_flowers(bouquet);

        System.out.println();
        sort_freshness(bouquet, count);
        output_flowers(bouquet);

        System.out.println();
        System.out.println("КВІТКА В БУКЕТІ, ЩО ВІДПОВІДАЄ ЗАДАНОМУ ДІАПАЗОНУ ДОВЖИН (15-20 см):");
        System.out.println(Parametrs(flower_length(bouquet, 15.0, 20.0)));
        System.out.println();
        bouquet_price(bouquet);
    }

}
