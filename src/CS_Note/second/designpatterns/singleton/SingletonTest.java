package CS_Note.second.designpatterns.singleton;

class SingletonTest {
    private static final SingletonTest instance = new SingletonTest();

    private SingletonTest() {

    }

    public static SingletonTest getInstance() {
        return instance;
    }
}

class Single {
    private static volatile Single s = null;

    public Single() {
    }

    public static Single getInstance() {
        if (s == null) {
            synchronized (Single.class) {
                if (s == null)
                    s = new Single();
            }
        }
        return s;
    }
}
