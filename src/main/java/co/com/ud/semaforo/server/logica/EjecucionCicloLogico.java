/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.server.logica;

import co.com.ud.semaforo.server.dto.GrupoSemaforicoDto;
import co.com.ud.semaforo.server.dto.PasoDto;
import co.com.ud.semaforo.server.dto.PlanSemaforicoDto;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sierraj
 */
public class EjecucionCicloLogico {

    public void execute(PlanSemaforicoDto planSemaforicoDto, EnvioMensajesLogica envioMsn) {
        if (Objects.nonNull(envioMsn) && !validacionNumeroConectados(planSemaforicoDto, envioMsn.getCentralesSemaforicas().size())) {
            JOptionPane.showMessageDialog(null, "El numero de conexiones de grupos semaforicos deben ser: " + planSemaforicoDto.getNumeroCentral());
        } else {
            //Genero el ciclo deseado
            for (int i = 1; i <= 2; i++) {
                this.enviaSeñal(planSemaforicoDto, envioMsn, i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EjecucionCicloLogico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Boolean validacionNumeroConectados(PlanSemaforicoDto planSemaforicoDto, Integer numConectados) {
        if (planSemaforicoDto.getNumeroCentral() == numConectados) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean enviaSeñal(PlanSemaforicoDto planSemaforicoDto, EnvioMensajesLogica envioMsn, Integer tiempo) {
        for (GrupoSemaforicoDto item : planSemaforicoDto.getGrpSemaforico()) {
            //ID a enviar
            Integer id = item.getNro();
            String mensaje = this.buscaMensajeLista(item, tiempo);
            if (Objects.nonNull(mensaje)) {
                mensaje = mensaje.replaceFirst("^0+(?!$)", mensaje);
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
