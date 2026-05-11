import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class SmartDateGenerator {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        while (true) {

            printMenu();

            int choice = getIntInput("Enter choice: ");

            switch (choice) {

                case 1:
                    generateRandomDate();
                    break;

                case 2:
                    generateDOB();
                    break;

                case 3:
                    generateFutureDate();
                    break;

                case 4:
                    generateMultipleDates();
                    break;

                case 5:
                    showCalendar();
                    break;

                case 6:
                    countdown();
                    break;

                case 7:
                    System.out.println("\nProgram Ended.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice! Try again.");
            }
        }
    }

    // MENU
    static void printMenu() {

        System.out.println("\n========= SMART DATE GENERATOR =========");
        System.out.println("1. Generate Random Date");
        System.out.println("2. Generate DOB");
        System.out.println("3. Generate Future Date");
        System.out.println("4. Generate Multiple Dates");
        System.out.println("5. Show Calendar");
        System.out.println("6. Countdown To Date");
        System.out.println("7. Exit");
    }

    // SAFE INTEGER INPUT
    static int getIntInput(String message) {

        while (true) {

            try {

                System.out.print(message);
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter valid numbers only.");
            }
        }
    }

    // YES / NO INPUT
    static boolean askYesNo(String message) {

        while (true) {

            System.out.print(message);

            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("yes")) {
                return true;
            }

            else if (input.equalsIgnoreCase("no")) {
                return false;
            }

            else {
                System.out.println("Please type yes or no.");
            }
        }
    }

    // RANDOM DATE
    static void generateRandomDate() {

        int year;
        int month;
        int day;

        // YEAR
        if (askYesNo("Do you want to enter year? (yes/no): ")) {

            year = getIntInput("Enter year: ");

            if (year < 1 || year > 9999) {
                System.out.println("Invalid year.");
                return;
            }

        } else {

            year = 2000 + random.nextInt(31);
        }

        // MONTH
        if (askYesNo("Do you want to enter month? (yes/no): ")) {

            month = getIntInput("Enter month (1-12): ");

            if (month < 1 || month > 12) {
                System.out.println("Invalid month.");
                return;
            }

        } else {

            month = 1 + random.nextInt(12);
        }

        int maxDays = YearMonth.of(year, month).lengthOfMonth();

        // DAY
        if (askYesNo("Do you want to enter day? (yes/no): ")) {

            day = getIntInput("Enter day: ");

            if (day < 1 || day > maxDays) {
                System.out.println("Invalid day for this month.");
                return;
            }

        } else {

            day = 1 + random.nextInt(maxDays);
        }

        LocalDate date = LocalDate.of(year, month, day);

        printDateDetails(date);
    }

    // DOB GENERATOR
    static void generateDOB() {

        int year = 1980 + random.nextInt(31);
        int month = 1 + random.nextInt(12);

        int maxDays = YearMonth.of(year, month).lengthOfMonth();

        int day = 1 + random.nextInt(maxDays);

        LocalDate dob = LocalDate.of(year, month, day);

        System.out.println("\nGenerated DOB: " + dob);

        Period age = Period.between(dob, LocalDate.now());

        System.out.println("Age: " + age.getYears() + " years");
    }

    // FUTURE DATE
    static void generateFutureDate() {

        LocalDate today = LocalDate.now();

        int randomDays = 1 + random.nextInt(365);

        LocalDate futureDate = today.plusDays(randomDays);

        System.out.println("\nFuture Date: " + futureDate);

        printDateDetails(futureDate);
    }

    // MULTIPLE DATES
    static void generateMultipleDates() {

        int n = getIntInput("How many dates to generate? ");

        if (n <= 0) {
            System.out.println("Number must be greater than 0.");
            return;
        }

        System.out.println("\nGenerated Dates:");

        for (int i = 1; i <= n; i++) {

            int year = 2000 + random.nextInt(31);

            int month = 1 + random.nextInt(12);

            int maxDays = YearMonth.of(year, month).lengthOfMonth();

            int day = 1 + random.nextInt(maxDays);

            LocalDate date = LocalDate.of(year, month, day);

            System.out.println(i + ". " + date);
        }
    }

    // CALENDAR
    static void showCalendar() {

        int year = getIntInput("Enter year: ");

        int month = getIntInput("Enter month (1-12): ");

        if (month < 1 || month > 12) {

            System.out.println("Invalid month.");
            return;
        }

        YearMonth ym = YearMonth.of(year, month);

        LocalDate firstDay = ym.atDay(1);

        int startDay = firstDay.getDayOfWeek().getValue() % 7;

        String title = Month.of(month)
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        System.out.println("\n      " + title + " " + year);

        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 0; i < startDay; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= ym.lengthOfMonth(); day++) {

            System.out.printf("%2d ", day);

            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    // COUNTDOWN
    static void countdown() {

        try {

            int year = getIntInput("Enter year: ");

            int month = getIntInput("Enter month: ");

            int day = getIntInput("Enter day: ");

            LocalDate targetDate = LocalDate.of(year, month, day);

            long days = Duration.between(
                    LocalDate.now().atStartOfDay(),
                    targetDate.atStartOfDay()
            ).toDays();

            if (days > 0) {

                System.out.println("Days remaining: " + days);

            } else if (days == 0) {

                System.out.println("Today is the target date!");

            } else {

                System.out.println("That date already passed.");
            }

        } catch (DateTimeException e) {

            System.out.println("Invalid date entered.");
        }
    }

    // DATE DETAILS
    static void printDateDetails(LocalDate date) {

        System.out.println("\nGenerated Date: " + date);

        String monthName = date.getMonth()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        System.out.println("Month Name: " + monthName);

        DayOfWeek dayName = date.getDayOfWeek();

        System.out.println("Day: " + dayName);

        // RANDOM TIME
        int hour = random.nextInt(24);

        int minute = random.nextInt(60);

        int second = random.nextInt(60);

        System.out.printf(
                "Random Time: %02d:%02d:%02d%n",
                hour,
                minute,
                second
        );

        // WEEKEND CHECK
        if (dayName == DayOfWeek.SATURDAY ||
                dayName == DayOfWeek.SUNDAY) {

            System.out.println("It is a Weekend!");

        } else {

            System.out.println("It is a Weekday!");
        }

        // LUCKY DATE
        int dateNumber = date.getDayOfMonth();

        if (dateNumber == 7 || dateNumber == 11) {

            System.out.println("Lucky Date!");
        }

        // OTP
        int otp = 1000 + random.nextInt(9000);

        System.out.println("Date OTP: " + otp);
    }
}