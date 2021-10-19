import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class I18NManager {
    private HashMap<String, ResourceBundle> data; //Idioma
    private static I18NManager manager; //Crea mensaje
    private static Logger logger = Logger.getLogger(String.valueOf(I18NManager.class)); //Filtrar errores

    private I18NManager() {
        this.data = new HashMap<String,ResourceBundle>();
    } //Lista (String+Idioma)

    public static I18NManager getInstance(){ //Mira si hay instancia, sino lo crea
        if (manager==null) {
            logger.info("New instance");
            manager = new I18NManager();
        }
        return manager;
    }
    public String getText (String lenguage, String line, String country){ //Mira si existe el lenguaje, sino lo crea
        if (data.get(lenguage)==null){
            logger.info("Lenguage missing");
            manager.pushCache(lenguage,country);
        }
        return data.get(lenguage).getString(line);
    }

    private void pushCache(String lenguage, String country) { //Crea el lenguaje
        try{
            Locale locale = new Locale(lenguage, country);
            ResourceBundle RB = ResourceBundle.getBundle("MyLabels",locale); //Crea idioma del lenguaje
            data.put(lenguage,RB); //Añade lenguaje+idioma
        }
        catch (Exception exception){
            logger.info("Can't push cache");
        } //Error si no puede hacer lo anterior
    }
    public void cleanCache(){
        data.clear();
    } //Limpia cache
}
