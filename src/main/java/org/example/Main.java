import java.util.List;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ChatServer chatServer = new ChatServer();

        User sravani = new User("Sravani", chatServer);
        User manvi = new User("Manvi", chatServer);
        User harini = new User("Harini", chatServer);

        chatServer.sendMessage(new Message(sravani, List.of(manvi, harini), "Hey Guys! How is it going?"));
        chatServer.sendMessage(new Message(sravani, List.of(manvi), "Manvi, let's go out for lunch, what say? "));
        chatServer.sendMessage(new Message(sravani, List.of(manvi), "No, don't come..."));

        chatServer.undoLastMessage(sravani);

        chatServer.sendMessage(new Message(manvi, List.of(harini), "Are you there?"));

        sravani.blockUser(harini);
        chatServer.sendMessage(new Message(harini, List.of(sravani), "Sorry! I was busy"));

        System.out.println("\nChat History (Sravani):");
        Iterator<Message> messageHistoryIterator1 = sravani.iterator();
        while (messageHistoryIterator1.hasNext()) {
            System.out.println(messageHistoryIterator1.next());
        }

        System.out.println("\nChat History (Manvi):");
        Iterator<Message> messageHistoryIterator2 = manvi.iterator();
        while (messageHistoryIterator2.hasNext()) {
            System.out.println(messageHistoryIterator2.next());
        }

        System.out.println("\nChat History (Harini):");
        Iterator<Message> messageHistoryIterator3 = harini.iterator();
        while (messageHistoryIterator3.hasNext()) {
            System.out.println(messageHistoryIterator3.next());
        }

    }
}