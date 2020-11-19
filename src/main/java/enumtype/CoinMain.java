package enumtype;

import java.util.Arrays;

public class CoinMain {
    public static void main(String[] args) {
        Coin coin = Coin.HUSZAS;
        System.out.println(Arrays.deepToString( Coin.values() ));
    }
}
