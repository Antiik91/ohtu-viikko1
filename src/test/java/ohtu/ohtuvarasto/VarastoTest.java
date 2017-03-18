package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void negatiivinenVarastoSaldoOnNolla() {
        Varasto lol = new Varasto(-23);
        assertEquals(0, lol.getTilavuus(), vertailuTarkkuus);
    }

   @Test
   public void kuormitettuKonstruktoriTilavuusEnemmanKuinNOlla() {
       Varasto lol = new Varasto(22, 3);
       assertEquals(22,lol.getTilavuus(), vertailuTarkkuus );
   }
   
   @Test
   public void kuormitettuKonstruktoriTilavuusVähemmänKuinNOlla() {
       Varasto lol = new Varasto(-22, 3);
       assertEquals(0, lol.getTilavuus(), vertailuTarkkuus);
   }
   @Test
   public void kuormitettuKonsTilavuusTasanNolla() {
       Varasto lol = new Varasto(0,0);
       assertEquals(0, lol.getTilavuus(), vertailuTarkkuus);
   }
   @Test
   public void alkuSaldoNolla() {
       Varasto l = new Varasto(222, 0);
       assertEquals(0, l.getSaldo(), vertailuTarkkuus);
   }
   
   @Test
   public void alkuSaldoNegatiivinen() {
       Varasto l = new Varasto(222,-3);
       assertEquals(0, l.getSaldo(), vertailuTarkkuus);
   }
   
   @Test
   public void alkusSaldoPositiivinen() {
       Varasto l = new Varasto(222, 2);
       assertEquals(2, l.getSaldo(), vertailuTarkkuus);
   }
   
   @Test
   public void alkuSaldoMahtuu() {
       Varasto l = new Varasto(2,2);
       assertEquals(2, l.getSaldo(), vertailuTarkkuus);
   }
   
   @Test
   public void alkuSaldoEiMahdu() {
       Varasto l = new Varasto(20, 2222.5);
       assertEquals(20, l.getSaldo(), vertailuTarkkuus);
   }
   
   @Test
   public void lisaaVarastoonTestNegJaTays() {
       double test = this.varasto.getSaldo();
       this.varasto.lisaaVarastoon(-222.4);
       assertEquals(test,varasto.getSaldo(), vertailuTarkkuus);
       double tilavuus = this.varasto.getTilavuus();
       this.varasto.lisaaVarastoon(2000.0);
       assertEquals(tilavuus, varasto.getSaldo(), vertailuTarkkuus);
   }
   @Test
   public void otaVarastosta() {
       double neg = this.varasto.getSaldo();
       this.varasto.otaVarastosta(-22.23);
       assertEquals(neg, varasto.getSaldo(), vertailuTarkkuus);
       double yli = this.varasto.otaVarastosta(2222.4);
       assertEquals(0, this.varasto.getSaldo(), vertailuTarkkuus);
       varasto = new Varasto(10);
       this.varasto.lisaaVarastoon(10);
       this.varasto.otaVarastosta(5);      
       assertEquals(5, this.varasto.getSaldo(),vertailuTarkkuus);
   }
   
   @Test
   public void testaaTostring() {
       Varasto test = new Varasto(33, 10);
       String toTest = "saldo = 10.0, vielä tilaa 23.0";
       assertEquals(toTest, test.toString());
   }
}