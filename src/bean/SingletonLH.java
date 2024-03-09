package bean;


public class SingletonLH {
    private static volatile SingletonLH singletonLH;

    private SingletonLH() {
    }

    public static SingletonLH getSingletonLH() {
        if (singletonLH == null) {
            synchronized (SingletonLH.class) {
                if (singletonLH == null) {
                    singletonLH = new SingletonLH();
                }
            }
        }
        return singletonLH;
    }
}
