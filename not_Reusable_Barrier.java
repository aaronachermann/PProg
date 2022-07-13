public class MyBarrier {
  private int n;//number of threads

  MyBarrier (int n){
    this.n=n;
  }
  synchronized void await() throws InterruptedException{
    n--;
    if (n==0) notifyAll():
    else while(n>0) {wait();}
  }
}
