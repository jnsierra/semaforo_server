/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.ud.semaforo.server.dto;

import java.util.List;
import lombok.Data;

/**
 *
 * @author sierraj
 */
@Data
public class PlanSemaforicoDto {
    
    private String nombreInterseccion;
    private Integer numeroCentral; 
    private List<GrupoSemaforicoDto> grpSemaforico;
    private Integer cicloIntersecion;
    
}
