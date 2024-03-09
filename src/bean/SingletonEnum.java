package bean;

public enum SingletonEnum {
    INSTANCE;
    SingletonEnum() { System.out.println("枚举创建单例对象了"); }
}
