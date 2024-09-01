package org.example;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    int name;
    int role;
    @Override
    public int hashCode() {
        //   return super.hashCode(name,id,role);

        return Objects.hash(name,role);
    }
   @Override
    public boolean equals(Object o){

        if (o==this)return true;
       Main m=(Main) o;
        if (m.name==this.name&&m.role==this.role)return true;
        return false;
    }

    @Override
    public String toString() {
        return "Main{" +
                "name=" + name +
                ", role=" + role +
                '}';
    }

    public static void main(String[] args) {

        List<Integer> lt= Arrays.asList(10,3,8,8);
       //sum using stream and reduce.
//       int sum1=lt.stream().reduce(0,(a,b)->a+b);
//       int sum= lt.stream().reduce(0,SumCal::add);

        int sum1=lt.stream().reduce(0,SumCal::add);

        int sum2=lt.stream().reduce(0,(a,b)->a+b);

       List<Integer> squre=lt.stream().map(x->x*x).toList();
       //or
        List<Integer> sq=lt.stream().map(x->x*x).collect(Collectors.toList());

        List<Integer> even=lt.stream().filter(x->x%2==0).collect(Collectors.toList());


        Main m1=new Main();
        m1.role=20;
        m1.name=10;
        Main m2=new Main();
        m2.name=10;
        m2.role=20;

        Set<Main> st=new HashSet<>();
        st.add(m1);
        System.out.println(st.contains(m2));





        Collections.sort(lt,new Com());
     //   System.out.println(even);

     //   ThreadImpl th1=new ThreadImpl();
        MyThread2 thread2=new MyThread2();

        thread2.start();



    }
}