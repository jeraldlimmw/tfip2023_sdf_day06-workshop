package sg.edu.nus.iss.app.server;

import java.io.IOException;
import java.net.Socket;

public class CookieClientHandler implements Runnable {
    
    private Socket sock;
    private String cookieFile;

    public CookieClientHandler(Socket s, String cookieFile) {
        this.sock = s;
        this.cookieFile = cookieFile;
    }

    @Override
    public void run() {
        NetworkIO netIO = null;
        String request = "";
        try {
            netIO = new NetworkIO(sock);
            while (true) {
                request = netIO.read();
                if (request.trim().equals("end")) {
                    break;
                }
                if (request.trim().equals("get-cookie")) {
                    String randomCookieResponse = Cookie.getRandomCookie(this.cookieFile);
                    netIO.write(randomCookieResponse);
                    break;
                } else {
                    netIO.write("ERROR ! Invalid Command");
                }
                netIO.close();
                sock.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
