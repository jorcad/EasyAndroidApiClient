package ca.sukhni.net.android.api.client;

public interface ApiClientInterface
{
	public abstract void executeAndBlock(final ApiClientHandler handler);
	public abstract void executeOnThread(final ApiClientHandler handler);
	public abstract void executeOnAsyncTask(final ApiClientHandler handler);
	public abstract void cancelAsyncTask();
	public abstract void cancelAsyncTask(final boolean mayInterruptIfRunning);
}
