public class AppController {
  private User currentUser;
    private Network network;
    private AlertManager alertManager;

    public AppController() {
        currentUser = new User("Arsh", "Campus Dorm");
        network = new Network();
        alertManager = new AlertManager();
    }

    public void startApp() {
        System.out.println("DisasterConnect started.");
        currentUser.showUserInfo();
    }

    public void sendSOS() {
        Message sos = new Message(currentUser.name, "SOS! Need help near library.");
        network.broadcast(sos);
        alertManager.playAlertSound();
    }

    public static void main(String[] args) {
        AppController app = new AppController();
        app.startApp();
        app.sendSOS();
    }

  
}
