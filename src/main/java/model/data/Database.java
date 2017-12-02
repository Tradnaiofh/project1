package model.data;

import model.entity.Necklace;
import model.entity.PreciousStone;
import model.entity.Stone;

import java.util.ArrayList;
import java.util.List;

/**
 * Database
 * Singleton class to simulate database behaviour
 * created on 02.12.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class Database {
    private static Database instance = new Database();

    private List<Stone> stones = new ArrayList<>();
    private List<Necklace> necklaces = new ArrayList<>();

    private Database() {
        stones.add(new PreciousStone.Builder()
                .color("red")
                .transparency(1)
                .name("ruby")
                .weight(10)
                .price(3).build());
        stones.add(new PreciousStone.Builder()
                .color("blue")
                .transparency(1)
                .name("opal")
                .weight(3)
                .price(5).build());
    }

    public static Database getInstance() {
        return instance;
    }

    public List<Stone> getStones() {
        return stones;
    }

    public void setStones(List<Stone> stones) {
        this.stones = stones;
    }

    public List<Necklace> getNecklaces() {
        return necklaces;
    }

    public void setNecklaces(List<Necklace> necklaces) {
        this.necklaces = necklaces;
    }

}