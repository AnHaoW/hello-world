package interview;

public class Person implements Cloneable{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Person clone(){
        Person person = null;
        try{
            person =(Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return person;
    }

}
