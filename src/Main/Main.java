package Main;

import Scheduling.*;

import java.util.Scanner;

public class Main {

    public static int n = 0;

    public static void main(String[] args) {

        try {

            Scanner in = new Scanner(System.in);
            int resp = -1;

            for (int n = 10; n <= 20; n++) {

                Main.n = n;

                System.out.println("----- " + n + " -----");

                for (int i = 1; i <= 4; i++) {

                    System.out.print("\n >>  ");
                    resp = i;
                    System.out.println(i);

                    Scheduler ordem = null;
                    boolean inicializouScheduler = true;

                    switch (resp) {

                        case 1:
                            ordem = new SchedulerFCFS();
                            break;
                        case 2:
                            ordem = new SchedulerSJN();
                            break;
                        case 3:
                            ordem = new SchedulerRotation();
                            break;
                        case 4:
                            ordem = new SchedulerPriority();
                            break;
                        case 9:
                            return;
                        default:
                            inicializouScheduler = false;
                    }

                    if (inicializouScheduler) {
                        long tempoInicial = System.currentTimeMillis();
                        ordem.simularPedidos();
                        long tempoFinal = System.currentTimeMillis();
                        System.out.println((tempoFinal - tempoInicial) + "ms");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
