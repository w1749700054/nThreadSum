package java7_2.chapter8;

public class Producer implements Runnable {
    private FileMock fileMock;
    private Buffer buffer;

    public Producer(FileMock fileMock, Buffer buffer) {
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLine(true);
        while(fileMock.hasMoreLine()){
            String line=fileMock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLine(false);
    }
}
