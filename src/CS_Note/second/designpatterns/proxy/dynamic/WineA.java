package CS_Note.second.designpatterns.proxy.dynamic;

public class WineA implements SellWine {
    @Override
    public void sell() {
        System.out.println("sell wine A");
    }

    @Override
    public void s() {
        System.out.println("win a s");
    }
}
