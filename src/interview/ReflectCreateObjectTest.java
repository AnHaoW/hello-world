package interview;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
//反射
public class ReflectCreateObjectTest {
    public static void main(String[] args) {
        test();
    }
    public static void test() {
        try {
            Class cls =  Class.forName("interview.Person");
            Constructor<Person> constructor = cls.getConstructor(int.class,String.class);
            Person person = constructor.newInstance(18,"wangah");
            System.out.println(person.toString());
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
