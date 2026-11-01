//https://leetcode.com/problems/print-zero-even-odd/description/

class ZeroEvenOdd {
    private int n;
    char turn = 'z'; //Zero(z) Odd(o) Even(e)
    boolean end = false;
    int count = 1;
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        while(true){
            while(turn != 'z'){
                if(count >= n){
                    end = true;
                    notifyAll();
                    return;
                }
                wait();
            }
            printNumber.accept(0);
            if(count%2 == 0) turn = 'e';
            else turn = 'o';
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        while(true){
            while(turn != 'e'){
                if(end) return;
                wait();
            }
            printNumber.accept(count);
            count++;
            turn = 'z';
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        while(true){
            while(turn != 'o'){
                if(end) return;
                wait();
            }
            printNumber.accept(count);
            count++;
            turn = 'z';
            notifyAll();
        }
    }
}