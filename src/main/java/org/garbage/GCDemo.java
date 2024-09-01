package org.garbage;

public class GCDemo {
    private String objName;

    public GCDemo(String name) {
        this.objName = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(objName + " is being garbage collected");
    }

    public static void main(String[] args) {
        GCDemo obj1 = new GCDemo("Object1");
        GCDemo obj2 = new GCDemo("Object2");

        obj1 = null; // Dereference obj1
        obj2 = null; // Dereference obj2

        System.gc(); // Suggest JVM to perform garbage collection
        System.out.println("End of main method");
    }
}
