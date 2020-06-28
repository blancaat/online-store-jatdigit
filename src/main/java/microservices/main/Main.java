package microservices.main;

import java.net.InetAddress;

import microservices.cart.main.CartServer;
import microservices.products.main.ProductsServer;
import microservices.registration.main.RegistrationServer;
import microservices.web.main.WebServer;

/**
 * Allow the servers to be invoked from the terminal. 
 * 
 * @author Blanca AT
 */

public class Main {

    public static final String NO_VALUE = "NO-VALUE";

    public static void main(String[] args) {

        String serverName = NO_VALUE;

        // Eureka Server assumed to be on localhost
        System.setProperty("registration.server.hostname", "localhost");

        // Look for server name and ignore -- arguments
        for (String arg : args) {
            if (arg.startsWith("--"))
                continue;

            if (serverName.equals(NO_VALUE))
                serverName = arg;
            else {
                System.out.println("Unexpected argument: " + arg);
                usage();
                return;
            }
        }

        // No server name, print usage and exit
        if (serverName == NO_VALUE) {
            usage();
            return;
        }

        // Get IP address, useful when running in containers
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println("Running on IP: " + inetAddress.getHostAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Determine which Main this application will run as
        if (serverName.equals("reg")) {
            RegistrationServer.main(args);
        } else if (serverName.equals("products")) {
            ProductsServer.main(args);
        } else if (serverName.equals("cart")) {
            CartServer.main(args);
        } else if (serverName.equals("web")) {
            WebServer.main(args);
        } else {
            // Unrecognized server type - print usage and exit
            System.out.println("Unknown server type: " + serverName);
            usage();
        }
    }

    /**
     * Print application usage information to console.
     */
    protected static void usage() {
        System.out.println();
        System.out.println("USAGE: modify Dockerfile. On entrypoint -> java -jar ... <server-name>");
        System.out.println("     where");
        System.out.println("       server-name is 'reg', " + "'products', " +  "'cart' or 'web'");
        System.out.println(
                "     optionally specify --registration.server.hostname=<IP-address> if its running on container");
        System.out.println();
    }
}