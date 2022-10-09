/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.server.vista;

import co.com.ud.semaforo.server.logica.EjecucionCicloLogico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lombok.Setter;

/**
 *
 * @author sierraj
 */
public class PararCicloControlador implements ActionListener {

    private VistaServer vistaServer;
    @Setter
    private EjecucionCicloLogico ejecucionCicloLogico;

    public PararCicloControlador(VistaServer vistaServer ) {
        this.vistaServer = vistaServer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.vistaServer.getEjecutarInicioBtn().setEnabled(true);
        this.vistaServer.getPararButton().setEnabled(false);
        //Paro la ejecución del hilo
        ejecucionCicloLogico.setContinuar(Boolean.FALSE);
    }

}
