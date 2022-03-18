package sk.uniza.fri.inf.pc.hardware;

/**
 * 14. 3. 2022 - 13:39
 *
 * @author Michal
 */
public class Pocitac {

    private final UsbHub internyHub;

    public Pocitac(int pocetPortov) {
        this.internyHub = new UsbHub(pocetPortov);
    }

    public int getPocetPortov() {
        return this.internyHub.getPocetPortov();
    }

    public UsbPort getUsbPort(int index) {
        return this.internyHub.getUsbPort(index);
    }

    public UsbPort getVolnyUsbPort() {
        return this.internyHub.getVolnyUsbPort();
    }

    public void vypisVsetkyZariadenia() {
        this.internyHub.vypisVsetkyZariadenia();
    }
}
