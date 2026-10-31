//https://leetcode.com/problems/print-foobar-alternately/
class FooBar {
    private int n;
    char turn = 'f';

    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(turn == 'b') wait();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            turn = 'b';
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(turn == 'f') wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            turn = 'f';
            notifyAll();
        }
    }
}