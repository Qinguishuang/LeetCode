package CS_Note.second.designpatterns.proxy.dynamic;

public class WineB implements SellWine {

    @Override
    public void s() {
        System.out.println("win b s");
    }

    @Override
    public void sell() {
        System.out.println("sell wine B");
    }
}
