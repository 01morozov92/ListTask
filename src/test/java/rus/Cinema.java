package rus;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("¬ведите пожалуйста название фильма:");
        String movie = read.nextLine();
        System.out.println("¬ведите пожалуйста номер р€да:");
        int row = read.nextInt();
        System.out.println("¬ведите пожалуйста номер места:");
        int seat = read.nextInt();
        Ticket ticket = new Ticket(movie, row, seat);
        System.out.println("Movie: " + ticket.getMovie());
        System.out.println("Row: " + ticket.getRow());
        System.out.println("Seat: " + ticket.getSeat());
    }

    static class Ticket{
        private final String movie;
        private final int row;
        private final int seat;

        public Ticket(String movie, int row, int seat) {
            this.movie = movie;
            this.row = row;
            this.seat = seat;
        }

        public String getMovie(){
            return this.movie;
        }

        public int getRow(){
            return this.row;
        }

        public int getSeat(){
            return this.seat;
        }
    }
}
