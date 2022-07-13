public class Reusable_Barrier {
    final int n; //number of threads
    private int i = 0;
    private boolean holding = false;

    public void synchronized await(){
        while(holding){
            wait();
        }

        i++;

        while(i < n && !holding){
            wait();
        }
        if(i==n){
            holding = true;
            notifyAll();
        }
        i--;

        if(i==0){
            holding = false;
            notifyAll();
        }


    }
}
