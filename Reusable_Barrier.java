
class MyCyclicBarrier {
	private final Runnable barrierAction;
	private final int n; // total number ofthreads
	private int awaitThreads; // number of threads stil needed to reach the barrier

	public MyCyclicBarrier(int n, Runnable barrierAction) {
		this.n = n;
		this.awaitThreads = n;
		this.barrierAction = barrierAction;
	}

	public synchronized void await() throws InterruptedException {
		this.awaitThreads--;
		if (this.awaitThreads > 0) {
			this.wait();
		} else {
			this.awaitThreads = this.n;
			this.barrierAction.run();
			this.notifyAll();
		}
	}
}
