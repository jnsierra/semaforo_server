/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.server.logica;

import co.com.ud.semaforo.server.dto.GrupoSemaforicoDto;
import co.com.ud.semaforo.server.dto.PasoDto;
import co.com.ud.semaforo.server.dto.PlanSemaforicoDto;
import co.com.ud.semaforo.server.utiles.ServerUtilities;
import co.com.ud.semaforo.server.vista.VistaServer;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lombok.Data;

/**
 *
 * @author sierraj
 */
@Data
public class EjecucionCicloLogico extends Thread {

    private PlanSemaforicoDto planSemaforicoDto;
    private EnvioMensajesLogica envioMsn;
    private VistaServer vista;
    private Integer ciclo;
    private Boolean continuar;

    public EjecucionCicloLogico() {
        this.continuar = Boolean.FALSE;
        this.ciclo = 1;
    }
    
    
    @Override
    public void run() {
        while (continuar) {
            this.vista.getConectadosTextArea().append("Inicia el cilco: " + this.ciclo);
            this.vista.getConectadosTextArea().append(System.lineSeparator());
            for (int i = 1; i <= planSemaforicoDto.getCicloIntersecion(); i++) {
                this.vista.getConectadosTextArea().append("Segundo: " + i);
                this.vista.getConectadosTextArea().append(System.lineSeparator());
                this.enviaSeñal(planSemaforicoDto, envioMsn, i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EjecucionCicloLogico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public Boolean validateConnections() {
        if (Objects.nonNull(envioMsn)
                && !validacionNumeroConectados(planSemaforicoDto, envioMsn.getCentralesSemaforicas().size())) {
            JOptionPane.showMessageDialog(null, "El numero de conexiones de grupos semaforicos deben ser: " + planSemaforicoDto.getNumeroCentral());
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Boolean validacionNumeroConectados(PlanSemaforicoDto planSemaforicoDto, Integer numConectados) {
        if (numConectados.equals(planSemaforicoDto.getNumeroCentral())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean enviaSeñal(PlanSemaforicoDto planSemaforicoDto, EnvioMensajesLogica envioMsn, Integer tiempo) {
        //Iteramos sobre cada uno de los grupos semaforicos
        Integer numGrpSemaforicos = planSemaforicoDto.getNumeroCentral(); // Este es el numero de grupos semaforicos que existe para la simulacion
        for (int i = 0; i < numGrpSemaforicos; i++) {
            GrupoSemaforicoDto item = planSemaforicoDto.getGrpSemaforico().get(i);
            //ID a enviar
            Integer id = item.getNro();
            String mensaje = this.buscaMensajeLista(item, tiempo);
            if (Objects.nonNull(mensaje)) {
                mensaje = ServerUtilities.eliminarCerosIzq(mensaje);
                int decimal = Integer.parseInt(mensaje, 2);
                envioMsn.enviarMensaje(id, "" + decimal);
            }
        }
        return Boolean.TRUE;
    }

    public String buscaMensajeLista(GrupoSemaforicoDto grupoSemaforicoDto, Integer tiempo) {
        Optional<PasoDto> item = grupoSemaforicoDto.getPasos().stream().parallel().filter(s -> tiempo.equals(s.getTiempo()))
                .findFirst();
        if (item.isPresent()) {
            return item.get().getAccion();
        }
        return null;
    }

}
