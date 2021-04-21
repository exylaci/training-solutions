package gyaxi.hegedusaniko.priceisright;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuctionTest {

    @Test
    void priceIsRightTest() {
        Auction a = new Auction();

        assertEquals(1, a.priceIsRight(new int[]{900, 885, 989, 1}, 800));
        assertEquals(250, a.priceIsRight(new int[]{200, 300, 250, 999, 40}, 280));
        assertEquals(-1, a.priceIsRight(new int[]{200}, 120));
        assertEquals(-1, a.priceIsRight(new int[]{500, 300, 241, 99, 501}, 50));
    }
}