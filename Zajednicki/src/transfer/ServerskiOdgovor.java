package transfer;

import java.io.Serializable;

public class ServerskiOdgovor implements Serializable {
    private int operacija;
    private Object odgovor;
    private boolean fleg;
    private String poruka;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(int operacija, Object odgovor, boolean fleg, String poruka) {
        this.operacija = operacija;
        this.odgovor = odgovor;
        this.fleg = fleg;
        this.poruka = poruka;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public boolean isFleg() {
        return fleg;
    }

    public void setFleg(boolean fleg) {
        this.fleg = fleg;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

}
