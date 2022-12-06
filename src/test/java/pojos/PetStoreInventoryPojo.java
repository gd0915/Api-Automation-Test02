package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetStoreInventoryPojo {
    private int  notAvailable;
    private int totvs;
    private int sold;
    private int  getNotAvailable;
    private int string;
    private int unavailable;
    private int pending;
    private int available;
    @JsonProperty("Kebipmj")
    private int kebipmj;
    private int totvs1;

    public PetStoreInventoryPojo(int notAvailable, int totvs, int sold, int getNotAvailable, int string, int unavailable, int pending, int available, int kebipmj, int totvs1) {
        this.notAvailable = notAvailable;
        this.totvs = totvs;
        this.sold = sold;
        this.getNotAvailable = getNotAvailable;
        this.string = string;
        this.unavailable = unavailable;
        this.pending = pending;
        this.available = available;
        this.kebipmj = kebipmj;
        this.totvs1 = totvs1;
    }

    public PetStoreInventoryPojo() {
    }

    public int getNotAvailable() {
        return notAvailable;
    }

    public void setNotAvailable(int notAvailable) {
        this.notAvailable = notAvailable;
    }

    public int getTotvs() {
        return totvs;
    }

    public void setTotvs(int totvs) {
        this.totvs = totvs;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getGetNotAvailable() {
        return getNotAvailable;
    }

    public void setGetNotAvailable(int getNotAvailable) {
        this.getNotAvailable = getNotAvailable;
    }

    public int getString() {
        return string;
    }

    public void setString(int string) {
        this.string = string;
    }

    public int getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(int unavailable) {
        this.unavailable = unavailable;
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getKebipmj() {
        return kebipmj;
    }

    public void setKebipmj(int kebipmj) {
        this.kebipmj = kebipmj;
    }

    public int getTotvs1() {
        return totvs1;
    }

    public void setTotvs1(int totvs1) {
        this.totvs1 = totvs1;
    }

    @Override
    public String toString() {
        return "PetStoreInventoryPojo{" +
                "notAvailable=" + notAvailable +
                ", totvs=" + totvs +
                ", sold=" + sold +
                ", getNotAvailable=" + getNotAvailable +
                ", string=" + string +
                ", unavailable=" + unavailable +
                ", pending=" + pending +
                ", available=" + available +
                ", kebipmj=" + kebipmj +
                ", totvs1=" + totvs1 +
                '}';
    }
}
