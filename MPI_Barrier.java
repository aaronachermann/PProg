public void MPI_Barrier() {
    int rank = MPI.COMM_WORLD.Rank();
    int size = MPI.COMM_WORLD.Size();
    boolean[] buf = new boolean[1];

    if (rank == 0) {
       // Wait until every process sent a meaningless boolean
       for (int i = 1; i < size; i++) {
           MPI.COMM_WORLD.Recv(buf, 0, 1, MPI.BOOLEAN, i, 0);
       }

       // All processes are ready

       // Send a signal to all processes so that they can continue
       for (int i = 1; i < size; i++) {
           MPI.COMM_WORLD.Send(buf, 0, 1, MPI.BOOLEAN, i, 0);
       }
    } else {
         MPI.COMM_WORLD.Send(buf, 0, 1, MPI.BOOLEAN, 0, 0); // send meaningless boolean
         MPI.COMM_WORLD.Recv(buf, 0, 1, MPI.BOOLEAN, 0, 0); // wait until process 0 gives signal
    }
 }
