package interview;

import java.io.*;
public class Employee implements Serializable {

    String name;
    int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public void Serialize(Employee employee) throws Exception {

        // 文件输出流指定输出的位置(与系统有关的文件名)
        FileOutputStream fos = new FileOutputStream("f:/employee.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        // 要写入的对象
        oos.writeObject(employee);
        System.out.println("Employee对象序列化成功！");
        oos.close();
    }

    public Employee Deserialize() throws Exception {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("f:/employee.txt")));
        Employee employee = (Employee) ois.readObject();
        System.out.println("Employee对象反序列化成功！");
        return employee;
    }
    public static void main(String[] args) throws Exception {

        Employee employee = new Employee("张三", 20);
        try {
            employee.Serialize(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Employee employee1 = employee.Deserialize();
        System.out.println(employee1.name);
    }
}