package repo;

import domain.Ticket;

public class Repository {
    private Ticket[] tickets = new Ticket[0];

    public void save (Ticket ticket) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets,0,tmp,0,tickets.length);
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById (int id) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id){
                tmp[index] = ticket;
                index++;
            }
            tickets = tmp;
        }
    }

    public Ticket[] getAll () {
        return tickets;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getDepAirport().contains(from) && ticket.getDestAirport().contains(to)) {
            return true;
            }
            return false;
        }
}
//https://github.com/Watsupkin/AirTickets.git