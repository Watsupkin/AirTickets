package domain;

import repo.Repository;

public class Manager {

    Repository repo = new Repository();
    public Manager (Repository repo) {this.repo = repo;}

    public Ticket[] findByFromTo (String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getAll()) {
            if(repo.matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result,0,tmp,0,result.length);
                tmp[tmp.length -1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public void add (Ticket ticket){
        repo.save(ticket);
    }

    public Ticket[] findAll() {
        return repo.getAll();
    }

    public Manager () {

    }
}
