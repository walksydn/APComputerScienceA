/**
 * ---------------------------------------------------------------------------
 * S-h-e-n-e-n-d-e-h-o-w-a--H-i-g-h--S-c-h-o-o-l--T-e-c-h-n-o-l-o-g-y--D-e-p-t
 * ---------------------------------------------------------------------------
 * FILE: AlphaComparator.java
 *
 * DATE:  Mar 31, 2017
 *
 * PURPOSE: Comparators make it wicked easy to sort based on different criteria
 *          Props to the java gods for creating these....you rock!!
 *
 * @author mr Hanley
 * @version 1.0
 * ---------------------------------------------------------------------------
 *
 * h-a-n-l-e-y.c-o-.-n-r------t-e-a-m-2-0-.-c-o-m-----------------------------
 */
import java.util.Comparator;

public class AlphaComparator implements Comparator{
    public int compare(Object ter1, Object ter2){
        Territory t1 = (Territory)ter1;
        Territory t2 = (Territory)ter2;
        return t1.name.compareTo(t2.name);  //yeah, you know how we do it!!
    }
}
