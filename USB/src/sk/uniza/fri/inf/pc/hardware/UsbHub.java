package sk.uniza.fri.inf.pc.hardware;

public class UsbHub implements IUsbZariadenie {
    private final String nazov;
    private final String vyrobca;
    private UsbPort[] porty;
    private UsbPort usbPort;

    public UsbHub(String nazov, String vyrobca, int pocetPortov) {
        this.nazov = nazov;
        this.vyrobca = vyrobca;
        this.porty = new UsbPort[pocetPortov];
        for (int i = 0; i < this.porty.length; i++) {
            this.porty[i] = new UsbPort();
        }
    }

    UsbHub(int pocetPortov) {
        this("neznamy", "neznamy", pocetPortov);
    }

    public int getPocetPortov() {
        return this.porty.length;
    }

    public UsbPort getUsbPort(int index) {
        return this.porty[index];
    }

    public UsbPort getVolnyUsbPort() {
        for (UsbPort port : porty) {
            if (!port.jeObsadeny()) {
                return port;
            }
        }
        return null;
    }

    private void vypisVsetkyZariadenia(int odsadenie) {
        for (int i = 0; i < this.porty.length; i++) {
            UsbPort port = this.porty[i];
            System.out.print("\t".repeat(odsadenie));
            System.out.printf("[%d]\t%s\n", i, port);
            IUsbZariadenie usbZariadenie = port.getUsbZariadenie();
            if (usbZariadenie instanceof UsbHub) {
                ((UsbHub)usbZariadenie).vypisVsetkyZariadenia(odsadenie + 1);
            }
        }
    }

    public void vypisVsetkyZariadenia() {
        this.vypisVsetkyZariadenia(0);
    }

    @Override
    public String getNazov() {
        return this.nazov;
    }

    @Override
    public String getVyrobca() {
        return this.vyrobca;
    }

    @Override
    public void pripojDoUsbPortu(UsbPort usbPort) {
        if (usbPort.jeObsadeny()) {
            System.err.println("Usb port je uz obsadeny");
            return;
        } else if (this.usbPort != null) {
            this.usbPort.setUsbZariadenie(null);
        }
        usbPort.setUsbZariadenie(this);
        this.usbPort = usbPort;
    }

    @Override
    public void odpojZUsbPortu() {
        if (this.usbPort == null) {
            System.err.println("Nieje pripojena");
            return;
        }
        this.usbPort.setUsbZariadenie(null);
        this.usbPort = null;
    }

    @Override
    public String toString() {
        return "UsbHub{" +
                "nazov='" + nazov + '\'' +
                ", vyrobca='" + vyrobca + '\'' +
                ", pocetPortov='" + this.getPocetPortov() + '\'' +
                '}';
    }


}