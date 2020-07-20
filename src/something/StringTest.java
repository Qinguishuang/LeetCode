package something;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 通过反射修改字符串的值
 */
public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "hello world";
        System.out.println(str);

        // 获取Sting中的value字段
        Field fieldStr = String.class.getDeclaredField("value");
        // 修改value访问权限
        fieldStr.setAccessible(true);
        // 获取str对象上的value属性的值
        char[] value = (char[]) fieldStr.get(str);
        value[0] = 'H';
        System.out.println(str);

        StringBuilder s = new StringBuilder("你好啊世界");
        s.setLength(4);
        System.out.println(s);

    }
}
