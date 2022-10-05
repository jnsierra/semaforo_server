/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.server.vista;

import co.com.ud.semaforo.server.dto.PlanSemaforicoDto;
import co.com.ud.semaforo.server.logica.EnvioMensajesLogica;
import co.com.ud.semaforo.server.logica.ReadFileJsonlogica;
import co.com.ud.semaforo.server.logica.ServerSemaforo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Optional;
import javax.swing.JOptionPane;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sierraj
 */
public class SemaforoServerControlador implements ActionListener{
    
    private VistaServer vista;
    private ServerSemaforo serverSemaforo;
    private EnvioMensajesLogica envioMensajesLogica;
    
    private ReadFileJsonlogica readFileJsonlogica;
    private String valorInterseccion;
    @Setter @Getter
    private PlanSemaforicoDto planSemaforicoDto;
    
    public SemaforoServerControlador(VistaServer vista, ServerSemaforo serverSemaforo, EnvioMensajesLogica envioMensajesLogica) {
        this.vista = vista;
        this.serverSemaforo = serverSemaforo;
        this.envioMensajesLogica = envioMensajesLogica;
        this.readFileJsonlogica = new ReadFileJsonlogica();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        obtenerValorSemaforo();
    }
    
    public void obtenerValorSemaforo(){
        valorInterseccion = (String) vista.getFilesCombo().getSelectedItem();
        if(valorInterseccion.contains("Intersección 1")){
            readFileJsonlogica.setUrl_json("src/main/resources/plan_semaforico_1.json");            
        }
        if(valorInterseccion.contains("Intersección 2")){
            readFileJsonlogica.setUrl_json("src/main/resources/plan_semaforico_2.json");            
        }
        if(valorInterseccion.contains("Intersección 3")){
            readFileJsonlogica.setUrl_json("src/main/resources/plan_semaforico_3.json");            
        }
        if(readFileJsonlogica.extraerObjetoPlan()){
            setPlanSemaforicoDto(readFileJsonlogica.getPlanSemaforicoDto());
        }
        serverSemaforo.setNumConexiones(getPlanSemaforicoDto().getNumeroCentral());
        serverSemaforo.setPlanSemaforicoDto(getPlanSemaforicoDto());
        this.vista.getCargarInformacionBtn().setEnabled(false);
        this.vista.getEjecutarInicioBtn().setEnabled(true);
        this.vista.setPlanSemaforicoDto(getPlanSemaforicoDto());
    }
    
}
