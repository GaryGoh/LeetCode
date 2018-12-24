package Practice;

import junit.framework.Assert;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Reflection {
    public static void main(String[] args) {
        Person p = new Person("Gary");

        try {
            // get the field of "name"
            Field nameField = p.getClass().getDeclaredField("name");
            nameField.setAccessible(true);
            Assert.assertEquals(nameField.get(p), "Gary");

            // get the field of "numOfPerson"
            Field numPerField = Person.class.getDeclaredField("numOfPerson");
            numPerField.setAccessible(true);
            Assert.assertEquals(numPerField.get(null), 1);

            // invoke the get method
            Method getter = Person.class.getDeclaredMethod("getName");
            Assert.assertEquals(getter.invoke(p, null), p.getName());

            // invoke the private set method
            Method setter = Person.class.getDeclaredMethod("setName", String.class);
            setter.setAccessible(true);
            setter.invoke(p, "Gary new name");
            Assert.assertEquals(p.getName(), "Gary new name");

            // access to the private constructor
            Constructor<Person> constructor = Person.class.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            Person p1 = constructor.newInstance();
            setter.invoke(p1, "Carina");
            Assert.assertEquals(p1.getName(), "Carina");

            // check the new instance if add up the numOfPerson
            Assert.assertEquals(numPerField.get(null), 2);

            // print the p display name
            Method displayMethod = Person.class.getDeclaredMethod("displayName", Person.class);

            // Gary new name - num of person: 2
            displayMethod.invoke(null, p);

            // Carina - num of person: 2
            displayMethod.invoke(null, p1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
