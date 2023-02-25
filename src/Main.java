import com.demo.dto.account.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashSet<Test> h= new HashSet<Test>();
        Test t1= new Test("1", "a");
        Test t2= new Test("2","b");
        h.add(t1);
        h.add(t2);
        System.out.println(t1);
        System.out.println(t2);
        t2.setName("c");
        System.out.println(t2);
        h.add(t2);
        Iterator<Test> it = h.iterator();
        while (it.hasNext()) {
            Test t= it.next();
            System.out.println(t + " " + t.getName() );
        }
    }
}


