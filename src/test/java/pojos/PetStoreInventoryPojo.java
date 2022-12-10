package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PetStoreInventoryPojo {
    private int sold;
    private int teststa5;
    private int string;
    private int unavailable;
    private int pending;
    private int available;

    public PetStoreInventoryPojo(int sold, int teststa5, int string, int unavailable, int pending, int available) {
        this.sold = sold;
        this.teststa5 = teststa5;
        this.string = string;
        this.unavailable = unavailable;
        this.pending = pending;
        this.available = available;
    }

    public PetStoreInventoryPojo() {
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getTeststa5() {
        return teststa5;
    }

    public void setTeststa5(int teststa5) {
        this.teststa5 = teststa5;
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

    @Override
    public String toString() {
        return "PetStoreInventoryPojo{" +
                "sold=" + sold +
                ", teststa5=" + teststa5 +
                ", string=" + string +
                ", unavailable=" + unavailable +
                ", pending=" + pending +
                ", available=" + available +
                '}';
    }
}
