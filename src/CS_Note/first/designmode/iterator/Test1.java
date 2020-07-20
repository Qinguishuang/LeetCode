package CS_Note.first.designmode.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 提供一种顺序访问聚合对象的数据, 不暴露对象内部表示
 * <p>
 * 优点:
 * 访问一个聚合对象的内容而无须暴露它的内部表示。
 * 遍历任务交由迭代器完成，这简化了聚合类。
 * 它支持以不同方式遍历一个聚合，甚至可以自定义迭代器的子类以支持新的遍历。
 * 增加新的聚合类和迭代器类都很方便，无须修改原有代码。
 * 封装性良好，为遍历不同的聚合结构提供一个统一的接口。
 * <p>
 * 缺点：增加了类的个数，这在一定程度上增加了系统的复杂性。
 * <p>
 * 抽象聚合(Aggregate)
 * 具体聚合(ConcreteAggregate): 返回具体的迭代器
 * <p>
 * 抽象迭代器(Iterator)
 * 具体迭代器(ConcreteIterator)
 */
public class Test1 {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add(1);
        aggregate.add(2);
        aggregate.add(3);
        aggregate.add(4);
        aggregate.add(5);

        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj.toString());
        }
    }

}


interface Aggregate {
    void add(Object o);

    void remove(Object o);

    Iterator getIterator();
}

class ConcreteAggregate implements Aggregate {

    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object o) {
        list.add(o);
    }

    @Override
    public void remove(Object o) {
        list.remove(o);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}

interface Iterator {
    Object next();
    Boolean hasNext();
}

class ConcreteIterator implements Iterator {

    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }


    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(++index);
        }
        return obj;
    }

    @Override
    public Boolean hasNext() {
        if (index < list.size() - 1)
            return true;
        else
            return false;
    }
}