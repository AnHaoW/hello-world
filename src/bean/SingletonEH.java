package bean;

public class SingletonEH {
    public static final SingletonEH singletonEH = new SingletonEH();

    private SingletonEH() {
    }

    public static SingletonEH getSingletonEH() {
        return singletonEH;
    }
}
