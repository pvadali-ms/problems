package misc;

import java.io.*;

/**
 * Created by PV029500 on 12/17/2016.
 */
public class SerializeTest implements Serializable {

    int randomVal;

    private SerializeTest() {

    }

    public static void main(String args[]) throws IOException, ClassNotFoundException {
        SerializeTest serializeTest = new SerializeTest();
        SerializeTest.InnerClass innerClass = new SerializeTest.InnerClass();
        NonStaticInnerClass nonStaticInnerClass = serializeTest.new NonStaticInnerClass();
        serializeTest.randomVal = 4;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("someObj"));
        objectOutputStream.writeObject(serializeTest);
        System.out.println(serializeTest.hashCode());
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("someObj"));
        SerializeTest newObj = (SerializeTest) objectInputStream.readObject();
        System.out.println(newObj.hashCode());
        System.out.println(newObj.randomVal);

        InterfaceClassTest interfaceClassTest = new InterfaceClassTest();
        interfaceClassTest.setCustomVal(45);
        InterfaceForClassTest interfaceForClassTest = interfaceClassTest;
        InterfaceClassTest another = (InterfaceClassTest) interfaceForClassTest;
        System.out.println(another.getCustomVal());
    }

    public static class InnerClass {

        public static void someMethod() {

        }
    }

    public class NonStaticInnerClass {

        public void someMethod() {

        }
    }
}
