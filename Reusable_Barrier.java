
class MyCyclicBarrier {
	private final Runnable barrierAction;
	private final int totalParties; // total number ofthreads
	private int awaitParties; // number of threads stil needed to reach the barrier

	public MyCyclicBarrier(int parties, Runnable barrierAction) {
		this.totalParties = parties;
		this.awaitParties = parties;
		this.barrierAction = barrierAction;
	}

	public synchronized void await() throws InterruptedException {
		this.awaitParties--;
		if (this.awaitParties > 0) {
			this.wait();
		} else {
			this.awaitParties = this.totalParties;
			this.barrierAction.run();
			this.notifyAll();
		}
	}
}
