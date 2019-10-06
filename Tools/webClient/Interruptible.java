/**
* An interface for classes that can be polled to see
* if theyfve been interrupted. Used by HttpClient
* and WebClient to allow the user to interrupt a network
* download.
*/
public interface Interruptible {
public boolean isInterrupted();
}