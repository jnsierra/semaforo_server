/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.server.vista;

import co.com.ud.semaforo.server.logica.EjecucionCicloLogico;
import co.com.ud.semaforo.server.logica.EnvioMensajesLogica;
import co.com.ud.semaforo.server.logica.ServerSemaforo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sierraj
 */
public class EjecucionCicloModel implements ActionListener{
    
    private VistaServer vista;
    private ServerSemaforo serverSemaforo;
    private EnvioMensajesLogica envioMensajesLogica;
    private EjecucionCicloLogico ejecucionCicloLogico;

    public EjecucionCicloModel(VistaServer vista, ServerSemaforo serverSemaforo, EnvioMensajesLogica envioMensajesLogica) {
        this.vista = vista;
        this.serverSemaforo = serverSemaforo;
        this.envioMensajesLogica = envioMensajesLogica;
        this.ejecucionCicloLogico = new EjecucionCicloLogico();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.ejecucionCicloLogico.execute(serverSemaforo.getPlanSemaforicoDto(), envioMensajesLogica);
    }    
}
