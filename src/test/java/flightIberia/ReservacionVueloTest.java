package flightIberia;
import FlightReservation.VueloBusqueda;
import com.google.common.util.concurrent.Uninterruptibles;
import configurarNevegador.AccesosTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class ReservacionVueloTest extends AccesosTest {

    @Test //(dataProvider = "dp")String data
    public void DatosVuelo() {
        //String datos[]=data.split(",");
        VueloBusqueda vuelobusqueda = new VueloBusqueda(driver);
        vuelobusqueda.pagina("https://www.iberia.com/");
        Uninterruptibles.sleepUninterruptibly(15, TimeUnit.SECONDS);
        vuelobusqueda.RealizarBusqueda();
        vuelobusqueda.clickBuscar();
    }
}
