public static Menstruation collectUserInput() {
    Scanner input = new Scanner(System.in);

    while (true) {
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        if (!name.matches("[A-Za-z]+")) {
            System.out.println("Name must only contain letters.");
            continue;
        }

        System.out.print("Enter your age: ");
        int age = input.nextInt();
        if (age < 11 || age > 50) {
            System.out.println("You are too young or too old.");
            continue;
        }

        System.out.print("Enter your cycle length in days (e.g., 28): ");
        int cycleLength = input.nextInt();
        if (cycleLength < 21 || cycleLength > 30) {
            System.out.println("Invalid cycle length.");
            continue;
        }

        System.out.println("Enter your last period start date:");
        System.out.print("  Month (1-12): ");
        int month = input.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Invalid month input.");
            continue;
        }

        System.out.print("  Day: ");
        int day = input.nextInt();
        if (day < 1 || day > 31) {
            System.out.println("Invalid day input.");
            continue;
        }

        System.out.print("  Year: ");
        int year = input.nextInt();

        System.out.println("Enter your flow degree: (light, moderate, low): ");
        input.nextLine();
        String flowDegree = input.nextLine().toLowerCase();
        if (!flowDegree.equals("light") && !flowDegree.equals("moderate") && !flowDegree.equals("low")) {
            System.out.println("Invalid flow degree. Please enter: light, moderate, or low.");
            continue;
        }

        Date lastPeriodStartDate = new Date(year - 1900, month - 1, day);
        Menstruation menstruation = new Menstruation(name, age, cycleLength, lastPeriodStartDate);
        menstruation.setFlowDegree(flowDegree);

        return menstruation;
    }
}

public static void main(String[] args) {
    Menstruation userCycle = collectUserInput();
    userCycle.showCycleInfo();
}
