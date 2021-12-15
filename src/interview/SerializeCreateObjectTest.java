package interview;
import java.io.*;

public class SerializeCreateObjectTest implements Serializable{
    //序列化存放路径 mac系统上
    private static final String path = "f:/person.txt";

    public static void main(String[] args) throws Exception {
        Person person = new Person(21, "wangah");
        SerializePerson(person);//序列化Person对象
        Person p = DeserializePerson();//反序列Perons对象
        System.out.println("name=" + p.getName());
    }

    /**
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static void SerializePerson(Person person) throws FileNotFoundException,
            IOException {

        // 文件输出流指定输出的位置(与系统有关的文件名)
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 要写入的对象
        oos.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oos.close();
    }

    /**
     * @throws Exception
     * @throws IOException
     */
    private static Person DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(path)));
        Person person = (Person) ois.readObject();
        System.out.println("Person对象反序列化成功！");
        return person;
    }
}