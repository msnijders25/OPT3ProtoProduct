import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PrijsProcesserKlantTest {

    @Test
    void testLoadEindPrijs_CasualFactoryStandardPrice() {
        KledingFactory casualFactory = new CasualKledingFactory();
        PrijsStrategie standardStrategie = new StandardPrijsStrategie();
        PrijsProcesserKlant processer = new PrijsProcesserKlant(casualFactory, standardStrategie);

        List<Prijs> finalPrices = processer.loadEindPrijs();

        // Assertions (no taxes yet, only base prices)
        assertEquals(2, finalPrices.size());
        assertEquals(20.0, finalPrices.get(0).getPrijs());
        assertEquals(36.0, finalPrices.get(1).getPrijs());
    }

    @Test
    void testLoadEindPrijs_LuxuryFactorySalePrice() {
        KledingFactory luxuryFactory = new LuxuryKledingFactory();
        PrijsStrategie saleStrategie = new SalePrijsStrategie();
        PrijsProcesserKlant processer = new PrijsProcesserKlant(luxuryFactory, saleStrategie);

        List<Prijs> finalPrices = processer.loadEindPrijs();

        // Assertions (with sale discount)
        assertEquals(2, finalPrices.size());
        assertEquals(32.0, finalPrices.get(0).getPrijs());
        assertEquals(60.0, finalPrices.get(1).getPrijs());
    }}
