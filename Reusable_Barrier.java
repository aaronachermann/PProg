
class MyCyclicBarrier {
	private final Runnable barrierAction;
	private final int n; // total number ofthreads
	private int awaitParties; // number of threads stil needed to reach the barrier

	public MyCyclicBarrier(int n, Runnable barrierAction) {
		this.n = n;
		this.awaitParties = n;
		this.barrierAction = barrierAction;
	}

	public synchronized void await() throws InterruptedException {
		this.awaitParties--;
		if (this.awaitParties > 0) {
			this.wait();
		} else {
			this.awaitParties = this.n;
			this.barrierAction.run();
			this.notifyAll();
		}
	}
}
