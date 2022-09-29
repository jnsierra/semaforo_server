package co.com.ud.semaforo.server.logica;

import co.com.ud.semaforo.server.dto.PlanSemaforicoDto;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import lombok.Getter;

/**
 *
 * @author sierraj
 */
public class ReadFileJsonlogica {
    @Getter
    private PlanSemaforicoDto planSemaforicoDto;
    private Gson gson;
    private final String URL_JSON = "src/main/resources/plan_semaforico.json";

    public ReadFileJsonlogica() {
        this.gson = new Gson();
    }
    
    public Boolean extraerObjetoPlan(){
        try (Reader reader = new FileReader(URL_JSON)) {

            // Convert JSON File to Java Object
            planSemaforicoDto = gson.fromJson(reader, PlanSemaforicoDto.class);
			
			// print staff object
            System.out.println(planSemaforicoDto);

        } catch (IOException e) {
            e.printStackTrace();
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
    
}
