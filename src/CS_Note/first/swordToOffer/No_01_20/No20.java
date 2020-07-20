package CS_Note.first.swordToOffer.No_01_20;

public class No20 {
    /**
     * 表示数值的字符串
     * -1.2e+3.4
     */
    public boolean isNumeric(String str) {
        if (str == null || str.trim().length() <= 0)
            return false;
        return str.trim().matches("^[+-]?((\\d+\\.?)|(\\d*\\.\\d+))([Ee][+-]?\\d+)?$");
        // [+-]?\\d(\\.\\d)?([eE][+-]?\\d)?
    }

    public static void main(String[] args) {
        No20 n = new No20();
        System.out.println(n.isNumeric("e9"));
        System.out.println(n.isNumeric("1.e"));
    }
}
