package Iterator;

import java.util.Iterator;

public class MyRangeIteratorfunction implements Iterator<Integer>{

        private int st;
        private int end;

        public MyRangeIteratorfunction(int st,int end){
            this.st = st;
            this.end = end;
    }

        public boolean hasNext(){
            return st <= end;
    }
        public Integer next(){
            int old = st;
            st += 2;
        return old;
    }


    }

