package domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String depAirport;
    private String destAirport;
    private int minsOfFly;

    @Override
    public int compareTo(Ticket o) {
    return this.price - o.price;
    }
}
