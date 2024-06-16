import user.AdminMode;
import user.CustomerMode;

public class TicketManagementEngine {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No mode specified. Terminating program now.");
            return;
        }

        String mode = args[0];
        String[] filePaths = new String[args.length - 1];
        System.arraycopy(args, 1, filePaths, 0, args.length - 1);

        try {
            if ("--admin".equalsIgnoreCase(mode)) {

                AdminMode adminService = new AdminMode();
                adminService.run(filePaths);
            } else if ("--customer".equalsIgnoreCase(mode)) {
                CustomerMode customerService = new CustomerMode();
                customerService.run(filePaths);
            } else {
                System.err.println("Invalid mode specified. Terminating program now.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred: " + e.getMessage());
        }
    }


    private void displayMessage() {
        System.out.println(" ________  ___ _____ \n" +
                "|_   _|  \\/  |/  ___|\n" +
                "  | | | .  . |\\ `--. \n" +
                "  | | | |\\/| | `--. \\\n" +
                "  | | | |  | |/\\__/ /\n" +
                "  \\_/ \\_|  |_/\\____/ \n" +
                "                    \n" +
                "                    \n");
    }
}
