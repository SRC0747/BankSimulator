package com.bankqueuesimulator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class BankSimulator {
    public BankSimulator() {
    }

    public static void COUNTER1(Queue<Integer> counter, Queue<Integer> customers, int minute, int servtime) {
        if (counter.isEmpty()) {
            counter.offer(customers.poll());
            servtime = minute;
        } else if (!counter.isEmpty()) {

            if (minute == servtime + 3) {
                counter.poll();
            }
        }
    }

    public static void COUNTER2(Queue<Integer> counter, Queue<Integer> customers, int minute, int servtime) {
        if (counter.isEmpty()) {
            counter.offer(customers.poll());
            servtime = minute;
        } else if (!counter.isEmpty()) {
            if (minute == servtime + 3) {
                counter.poll();
            }
        }
    }

    public static void COUNTER3(Queue<Integer> counter, Queue<Integer> customers, int minute, int servtime) {

        if (counter.isEmpty()) {
            counter.offer(customers.poll());
            servtime = minute;
        }
	        else if (!counter.isEmpty()) {
            if (minute == servtime + 3) {
                counter.poll();
            }
        }
    }

    public static int customerperminute() {
        Random R = new Random();
        int r = R.nextInt(4 - 0);
        if (r == 0 || r == 1) {
            return 0;
        }
        if (r == 2) {
            return 1;
        } else {
            return 2;
        }
    }


    public static void main(String args[]) {
        BankSimulator c = new BankSimulator();
        int customernumber;
        int arrivaltime;
        int servingtime;
        Queue<Integer> counter1 = new LinkedList<Integer>();
        Queue<Integer> counter2 = new LinkedList<Integer>();
        Queue<Integer> counter3 = new LinkedList<Integer>();
        Queue<Integer> customers = new LinkedList<Integer>();
        customernumber = 1;
        int servtime = 0;
        int servtime2 = 0;
        int servtime3 = 0;
        for (int minute = 1; minute <= 30; minute++) {
            int s;
            for (s = customerperminute(); s > 0; s--) {
                customers.offer(customernumber);
                customernumber++;
            }
            System.out.println("customers: " + customers);
            ////while(!customers.isEmpty()) here i add this still it will add null value for some reason
            COUNTER1(counter1, customers, minute, servtime);
            COUNTER2(counter2, customers, minute, servtime2);
            COUNTER3(counter3, customers, minute, servtime3);
            System.out.println(minute);
            System.out.println("customers: " + customers);
            System.out.println("counter1 : " + counter1);
            System.out.println("counter2 : " + counter2);
            System.out.println("counter3 : " + counter3);
        }
    }
}

