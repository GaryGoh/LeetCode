package Practice;

public class Person {
    private String name;
    private static int numOfPerson = 0;

    private Person() {
        numOfPerson++;
    }

    Person(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    static void displayName(Person p) {
        System.out.println(p.getName() + " - num of person: " + numOfPerson);
    }
}
