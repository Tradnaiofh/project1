import model.entity.Color;
import model.entity.PreciousStone;
import model.entity.SemiPreciousStone;

/**
 * Main
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        PreciousStone jewel = new PreciousStone.Builder()
                .price(10)
                .weight(10)
                .color(Color.RED)
                .name("ruby")
                .transparency(10)
                .build();

        SemiPreciousStone stone = new SemiPreciousStone.Builder()
                .color(Color.BLUE)
                .name("diamond")
                .price(0.33)
                .hardness(100)
                .weight(10)
                .build();

        System.out.println(jewel);
        System.out.println(stone);
    }


}
