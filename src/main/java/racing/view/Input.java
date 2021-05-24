package racing.view;

import java.util.Scanner;

import static racing.view.Output.*;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String makeCarNames() {
        Output.printStartMessage();
        return scanner.nextLine();
    }

    public static int makeGameRepeatCount() {
        Output.printInputCountMessage();
        return scanner.nextInt();
    }
}