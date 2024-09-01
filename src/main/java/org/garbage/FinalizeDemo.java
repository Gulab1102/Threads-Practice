package org.garbage;

public class FinalizeDemo {


    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("finalize() called");
        } finally {
            super.finalize();
        }
    }

    public static void main(String[] args) {

        FinalizeDemo obj = new FinalizeDemo();
        obj = null; // Dereference object
        System.gc(); // Request GC to run
        System.gc();
        System.out.println("Main method completed");

    }
}
