import java.util.ArrayList;

public class ExpensesManager {
    ArrayList<Double> expenses;

    ExpensesManager() {
        expenses = new ArrayList<>(); // Создаем список в конструкторе
    }

    double saveExpense(double moneyBeforeSalary, double expense) {
        expenses.add(expense); // Добавляем трату в список
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }

    void printAllExpenses() {
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println("Трата № " + (i + 1) + ". Потрачено " + expenses.get(i) + " рублей");
        }
    }

    double findMaxExpense() {
        double maxExpense = 0;
        for (Double expense : expenses) { // Используйте сокращённую форму цикла
            if (expense > maxExpense) {
                maxExpense = expense;
            }
        }
        return maxExpense;
    }

    void removeAllExpenses() {
        expenses.clear(); // Очищаем список расходов
        System.out.println("Список трат пуст.");
    }

    void removeExpense(int transaction) {
        if (expenses.isEmpty()) {
            System.out.println("Список трат пуст.");
            return;
        }

        int index = Integer.parseInt(null);
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i) == transaction) { // Используем == для сравнения double (может не сработать для нецелых значений)
                index = i;
                break;
            }
        }

        if (index >= 0) {
            expenses.remove(index);
            System.out.println("Трата удалена!");
        } else {
            System.out.println("Такой траты нет.");
        }
    }
}
