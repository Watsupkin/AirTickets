package domain;

import org.junit.jupiter.api.Test;
import repo.Repository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Manager mt = new Manager();
    Ticket first = new Ticket(1,10_000,"KUF","DMD",120);
    Ticket second = new Ticket(2,20_000,"ABA","KUF",120);
    Ticket third = new Ticket(3,15_000,"DMD","KUF",120);
    Ticket fourth = new Ticket(4,9_000,"KUF","ABA",120);
    Ticket fiveth = new Ticket(5,21_000,"DMD","ABA",120);
    Ticket sixth = new Ticket(6,13_000,"ABA","DMD",120);
    Ticket seventh = new Ticket(7,5_000,"KUF","DMD",240);

    @Test
    void sholdSortByPrice() {
        mt.add(first);
        mt.add(second);
        Ticket[] expected = {first,second};
        Ticket[] actual = {second,first};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByFromTo() {
        mt.add(first);
        mt.add(second);
        mt.add(third);
        mt.add(fourth);
        mt.add(fiveth);
        mt.add(sixth);
        mt.add(seventh);

        mt.findByFromTo("KUF","DMD");

        Ticket[] expected = {seventh, first};
        Ticket[] actual = mt.findByFromTo("KUF","DMD");
        Arrays.sort(actual);
        assertArrayEquals(expected,actual);
    }
}