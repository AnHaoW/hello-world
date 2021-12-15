
package interview;

public class CloneCreateObjectTest {
    public static void main(String[] args) {
        Person person = new Person(20, "zhouguizhi");
        Person p1 = (Person) person.clone();
        System.out.println("name:=" + p1.getName());

    }
}