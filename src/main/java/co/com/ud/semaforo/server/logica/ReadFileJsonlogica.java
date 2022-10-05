package co.com.ud.semaforo.server.logica;

import co.com.ud.semaforo.server.dto.PlanSemaforicoDto;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sierraj
 */
public class ReadFileJsonlogica {
    @Getter
    private PlanSemaforicoDto planSemaforicoDto;
    private Gson gson;
    @Setter @Getter
    private String url_json;

    public ReadFileJsonlogica() {
        this.url_json = "";
        this.gson = new Gson();
    }
    
    public Boolean extraerObjetoPlan(){
        try (Reader reader = new FileReader(url_json)) {

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
