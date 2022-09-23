/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.server.vista;

import co.com.ud.semaforo.server.logica.EnvioMensajesLogica;
import co.com.ud.semaforo.server.logica.ServerSemaforo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Optional;
import javax.swing.JOptionPane;

/**
 *
 * @author sierraj
 */
public class SemaforoServerControlador implements ActionListener{
    
    private VistaServer vista;
    private ServerSemaforo serverSemaforo;
    private EnvioMensajesLogica envioMensajesLogica;

    public SemaforoServerControlador(VistaServer vista, ServerSemaforo serverSemaforo, EnvioMensajesLogica envioMensajesLogica) {
        this.vista = vista;
        this.serverSemaforo = serverSemaforo;
        this.envioMensajesLogica = envioMensajesLogica;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String idText = vista.getIdClienteText().getText();
        if(Objects.nonNull(idText) && !"".equalsIgnoreCase(idText) && validarMensaje(vista.getMsnTxt().getText())){
            try {
                int id = Integer.parseInt(idText);
                Optional<Boolean> mensajeEnviado = envioMensajesLogica.enviarMensaje(id, vista.getMsnTxt().getText()); 
                if(mensajeEnviado.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No existen clientes conectados");
                }else if(mensajeEnviado.get()){
                    JOptionPane.showMessageDialog(null, "Mensaje enviado correctamente");
                }else if(!mensajeEnviado.get()){
                    JOptionPane.showMessageDialog(null, "Mensaje no enviado");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "El id debe ser numerico");
                ex.printStackTrace();
            }
        }
    }
    
    public Boolean validarMensaje(String mensaje){
        if(Objects.nonNull(mensaje) && !"".equalsIgnoreCase(mensaje)){
            try {
                int id = Integer.parseInt(mensaje);
                if(id<0 || id>255){
                    JOptionPane.showMessageDialog(null, "El mensaje debe ser mayor a cero e inferior a 255");
                    return Boolean.FALSE;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El mensaje debe ser numerico");
                return Boolean.FALSE;
            }
        }else{
            JOptionPane.showMessageDialog(null, "El mensaje no debe ser nulo");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
}
