/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.server.vista;

import co.com.ud.semaforo.server.dto.PlanSemaforicoDto;
import co.com.ud.semaforo.server.logica.EjecucionCicloLogico;
import co.com.ud.semaforo.server.logica.EnvioMensajesLogica;
import co.com.ud.semaforo.server.logica.ServerSemaforo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sierraj
 */
public class EjecucionCicloControlador implements ActionListener{
    
    private VistaServer vista;
    private ServerSemaforo serverSemaforo;
    private EnvioMensajesLogica envioMensajesLogica;
    @Setter @Getter
    private EjecucionCicloLogico ejecucionCicloLogico;
   
    @Setter @Getter
    private PlanSemaforicoDto planSemaforicoDto;
    


    public EjecucionCicloControlador(VistaServer vista, ServerSemaforo serverSemaforo, EnvioMensajesLogica envioMensajesLogica) {
        this.vista = vista;
        this.serverSemaforo = serverSemaforo;
        this.envioMensajesLogica = envioMensajesLogica;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.ejecucionCicloLogico = new EjecucionCicloLogico();
        //Valido si es posible iniciar la ejecucion del plan
        this.ejecucionCicloLogico.setPlanSemaforicoDto(this.vista.getPlanSemaforicoDto());
        this.ejecucionCicloLogico.setEnvioMsn(envioMensajesLogica);
        this.ejecucionCicloLogico.setVista(vista);
        if(this.ejecucionCicloLogico.validateConnections()){
            this.ejecucionCicloLogico.setContinuar(Boolean.TRUE);
            this.ejecucionCicloLogico.start();
            this.vista.getPararCicloControlador().setEjecucionCicloLogico(ejecucionCicloLogico);
            this.vista.getEjecutarInicioBtn().setEnabled(false);
            this.vista.getPararButton().setEnabled(true);
        }
    }
    
}
