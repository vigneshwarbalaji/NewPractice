import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimpleJava 
{
    public static void main(String[] args) 
    {
        List<Integer>l1 = new ArrayList<Integer>();
        Set<Integer>s1 = new HashSet<Integer>();
        
        l1.add(1);
        l1.add(2);
        l1.add(1);
        l1.add(1);
        l1.add(3);

        s1.add(2);
        s1.add(1);
        s1.add(5);
        s1.add(1);
        s1.add(3);
        s1.add(4);
        s1.add(6);
        s1.add(7);
        s1.add(7);
        s1.add(8);
        s1.add(9);
        s1.add(10);
        s1.add(7);

        //set wont preserves insertion order
        //set stores group of element in natural ascending order
        //set wont allow duplicates 
        System.out.println("The added numbers in set are: ");
        for (int s : s1) 
        {
            System.out.print(s+" ");    
        }

        //list preserves insertion order
        //list allows duplicates
        //list wont arrange the data in sorting order
        System.out.println("\n\nThe added numbers in list are: ");
        for (int l : l1) 
        {
            System.out.print(l+" ");
        }
    }
}