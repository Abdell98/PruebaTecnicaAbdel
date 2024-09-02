package FlightReservation;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class VueloBusqueda {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public VueloBusqueda(final WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    @FindBy (name = "flight_origin")
    private WebElement origen;// La ciudad de origen

    @FindBy (name = "flight_destiny")
    private WebElement destino; // La ciudad de destino

    @FindBy (name = "flight_hotel_round_date")
    private WebElement fechaIda; // la fecha de ida

    @FindBy (name = "flight_return_date")
    private WebElement fechaVuelta; // la fecha de vueltaç

    @FindBy (name = "flight_passengers")
    private WebElement pasajeros;

    @FindBy (xpath = "//*[@id=\"people-counter-1\"]/ul/li[2]/div[2]/button[2]")
    private WebElement adultos;

    @FindBy (xpath = "//*[@id=\"people-counter-1\"]/ul/li[5]/div[2]/button[2]")
    private WebElement niños;

    @FindBy (xpath = "//*[@id=\"people-counter-1\"]/ul/li[6]/div[2]/button[2]")
    private WebElement bebes;

    @FindBy (xpath = "//*[@id=\"buttonSubmit1\"]")
    private WebElement buscar;

    public void pagina(String Url){
        this.driver.get(Url);
    }

    public void RealizarBusqueda(){
        this.origen.sendKeys(a);
        this.destino.sendKeys(b);
        this.fechaIda.sendKeys(c);
        this.fechaVuelta.sendKeys(d);
        this.pasajeros.click();
        this.adultos.click();
        this.niños.click();
        this.bebes.click();
    }

    public void clickBuscar(){
        this.buscar.click();
    }

    //Leer el fichero JSON creado que lo he llamado Datos.json que se encuentra en la ruta resources/test-data
    JSONParser j = new JSONParser();
    FileReader f;
    {
        try {
            f = new FileReader("C:\\Users\\soufy\\IdeaProjects\\PruebaTecnicaAbdel\\src\\main\\resources\\test-data\\Datos.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    Object o;
    {
        try {
            o = j.parse(f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    // convert parsing object to JSON object
    JSONObject palabras = (JSONObject)o;
    String a = (String)palabras.get("origen");
    String b = (String)palabras.get("destino");
    String c = (String)palabras.get("fecha-ida");
    String d = (String)palabras.get("fecha-vuelta");
}
