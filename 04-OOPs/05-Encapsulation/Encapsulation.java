public class Encapsulation {

    // Private Data Members
    private String name;
    private int age;

    // Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter Methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {

        Encapsulation obj = new Encapsulation();

        // Setting values
        obj.setName("Aniket");
        obj.setAge(22);

        // Getting values
        System.out.println("Name: " + obj.getName());
        System.out.println("Age: " + obj.getAge());
    }
}