/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package co.com.ud.semaforo.server.test1.logica;

import co.com.ud.semaforo.server.test1.logica.Server;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sierraj
 */
public class Semaforo_server {

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.exeute();
        } catch (IOException ex) {
            Logger.getLogger(Semaforo_server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Semaforo_server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
