package Iterator;

import java.util.Iterator;

public class MyRange implements Iterable<Integer> {
    private int st;
    private int end;

    public MyRange(int st,int end){
        this.st = st;
        this.end = end;
    }
    public Iterator iterator(){
        return new MyRangeIteratorfunction(st,end);
    }
}
