import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Generic {

    public static void main(String[] args) throws FileNotFoundException {
        A a = new A();
        A b = new A();

        System.out.println("Hello World!" + a.i + a.j);
        System.out.println(" " + a.hashCode() + " " + b.hashCode());

        Set<A> s = new HashSet<>();


        s.add(new A());
        s.add(new A());

        System.out.println(s.size());


        for(A st: s){
            System.out.println(st);
        }
        System.out.println("-----------------");


    /*    TreeSet<A> treeSet = new TreeSet<A,Integer>(new Comparable<A>(){
            @Override
            public int compareTo(A o) {
                return 0;
            }
        });

        treeSet.add(new A(1,2));
        treeSet.add(new A(1,3));
        treeSet.add(new A(3,1));


        System.out.println(" " + treeSet.size());
        for (A trS : treeSet){
            System.out.println(trS);
        }*/

        System.out.println("-----------------");


        Map<A, Integer> map = new HashMap<>();
        map.put(new A(1,1), 0);
        map.put(new A(1,3), 1);
        map.put(new A(1,2), 2);
        map.put(new A(1,2), 3);

        for(A mp : map.keySet()){
            System.out.println(mp);

        }

        for( Integer vl: map.values()){
            System.out.println(vl);
        }

        for(Map.Entry<A,Integer> entry: map.entrySet()){
            System.out.println(entry + " " + entry.getKey() + " " + entry.getValue());

        }

        System.out.println("-----------------");

        LinkedHashMap<A, Integer> lnkdHsMap = new LinkedHashMap<>();
        lnkdHsMap.put(new A(1,1), 0);
        lnkdHsMap.put(new A(1,3), 1);
        lnkdHsMap.put(new A(1,2), 2);
        lnkdHsMap.put(new A(1,2), 3);

        for(A mp : lnkdHsMap.keySet()){
            System.out.println(mp);

        }

        for( Integer vl: lnkdHsMap.values()){
            System.out.println(vl);
        }

        for(Map.Entry<A,Integer> entry: lnkdHsMap.entrySet()){
            System.out.println(entry + " " + entry.getKey() + " " + entry.getValue());

        }

        System.out.println("-----------------");

        /*TreeMap<A, Integer> trMap = new TreeMap<A,Integer>(new Comparator<A>{

            @Override
            public int compare(A a1, A a2){
                long a = a1.getI()*Integer.MAX_VALUE + a1.getJ();
                long b = a2.getI()*Integer.MAX_VALUE + a2.getJ();

                if(a > b){
                    return 1;
                }
                else{
                    if(a < b)
                    {
                        return -1;
                    }
                    return 0;
                }
            }
        });
        trMap.put(new A(1,1), 0);
        trMap.put(new A(1,3), 1);
        trMap.put(new A(1,2), 2);
        trMap.put(new A(1,2), 3);

        for(A mp : trMap.keySet()){
            System.out.println(mp);

        }

        for( Integer vl: trMap.values()){
            System.out.println(vl);
        }

        for(Map.Entry<A,Integer> entry: trMap.entrySet()){
            System.out.println(entry + " " + entry.getKey() + " " + entry.getValue());

        }*/

        Properties prprts = new Properties();
        try {
            prprts.load(new FileInputStream("settings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String pswd = prprts.getProperty("password");
        System.out.println(pswd);

    }
}

 class A
 {
    public int i;
    public int j;

    public A(){

    }

     public A(int i, int j) {
         this.i = i;
         this.j = j;
     }

     public void setI(int i) {
         this.i = i;
     }

     public void setJ(int j) {
         this.j = j;
     }

     public int getI() {
         return i;
     }

     public int getJ() {
         return j;
     }

     @Override
     public String toString() {
         return "A{" +
                 "i=" + i +
                 ", j=" + j +
                 '}';
     }
     /*
     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         A a = (A) o;
         return i == a.i &&
                 j == a.j;
     }

     @Override
     public int hashCode() {
         return Objects.hash(i, j);
     }*/

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;

         A a = (A) o;

         if (i != a.i) return false;
         return j == a.j;
     }

     @Override
     public int hashCode() {
         int result = i;
         result = 31 * result + j;
         return result;
     }


 }