package util;

import model.entity.Necklace;
import model.entity.PreciousStone;
import model.entity.StoneNecklace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * NecklaceUtilTest
 * created on 29.11.2017
 *
 * @author Nikita Zabaykin vladlihovid@gmail.com
 * @version 1.0
 */
public class NecklaceUtilTest {
    private Necklace necklace;
    private Double expectedTotalWeight = 12d;
    private List<StoneNecklace> expectedFilteredPreciousStones;

    @Before
    public void setUp() throws Exception {
        necklace = new Necklace();
        necklace.getJewels().add(new PreciousStone.Builder()
                .weight(1)
                .price(8)
                .transparency(3)
                .name("Test 1")
                .build());
        necklace.getJewels().add(new PreciousStone.Builder()
                .weight(4)
                .price(2)
                .transparency(6)
                .name("Test 2")
                .build());
        necklace.getJewels().add(new PreciousStone.Builder()
                .weight(7)
                .price(5)
                .transparency(9)
                .name("Test 3")
                .build());

        expectedFilteredPreciousStones = new ArrayList<>();
        expectedFilteredPreciousStones.add(necklace.getJewels().get(1));
    }

    @Test
    public void getTotalPriceTest() throws Exception {
        Double actual = NecklaceUtil.getTotalWeight(necklace);

        Assert.assertEquals(expectedTotalWeight, actual);
    }

    @Test
    public void sortJewelsPriceTest() throws Exception {
        List<StoneNecklace> actual = NecklaceUtil.sortJewelsPrice(necklace);

        for (int i = 0; i < actual.size() - 1; i++) {
            if (actual.get(i).getPrice() > actual.get(i + 1).getPrice())
                Assert.fail();
        }
    }

    @Test
    public void getJewelsTransparencyRangeTest() {
        List<StoneNecklace> actual = NecklaceUtil.getJewelsTransparencyRange(necklace, 4d, 7d);

        Assert.assertEquals(expectedFilteredPreciousStones, actual);
    }
}
