
class MyCyclicBarrier {
	private final Runnable barrierAction;
	private final int n; // total number ofthreads
	private int reachThreads; // number of threads stil needed to reach the barrier

	public MyCyclicBarrier(int n, Runnable barrierAction) {
		this.n = n;
		this.reachThreads = n;
		this.barrierAction = barrierAction;
	}

	public synchronized void await() throws InterruptedException {
		this.reachThreads--;
		if (this.reachThreads > 0) {
			this.wait();
		} else {
			this.reachThreads = this.n;
			this.barrierAction.run();
			this.notifyAll();
		}
	}
}
