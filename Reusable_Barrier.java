//acquire(x) --> decrement x
//release(x) --> increment x
mutex=1; barrier1=0; barrier2=1; count=0
     acquire(mutex)
        count++;
        if (count==n)
           acquire(barrier2); release(barrier1)
     release(mutex)
     acquire(barrier1); release(barrier1);
     // barrier1 = 1 for all processes, barrier2 = 0 for all processes
     acquire(mutex)
        count--;
        if (count==0)
           acquire(barrier1); release(barrier2)
     release(mutex)                             
     acquire(barrier2); release(barrier2)
     // barrier2 = 1 for all processes, barrier1 = 0 for all processes
