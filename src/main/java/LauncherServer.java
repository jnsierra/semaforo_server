
import co.com.ud.semaforo.server.logica.ServerSemaforo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sierraj
 */
public class LauncherServer {

    public LauncherServer() {
        ServerSemaforo server = new ServerSemaforo();
        server.execute();
    }
    
    public static void main(String ... args){
        new LauncherServer();
    }
    
}
