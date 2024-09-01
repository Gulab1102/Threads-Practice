package org.garbage;

public class Resource implements AutoCloseable{
    public void doSomething() {
        System.out.println("Resource is being used");
    }
    @Override
    public void close() throws Exception {
        System.out.println("Resource is being closed");
    }

    public static void main(String[] args) throws Exception {
        try (Resource resource = new Resource()) {
            resource.doSomething();
        } // Resource is automatically closed here
        System.out.println("End of main method");
    }
}
