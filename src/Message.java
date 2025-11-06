public class Message {
    String sender;
    String content;

    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    public void display() {
        System.out.println(sender + ": " + content);
    }
}
