import java.io.*;
import java.util.*;

public class FileManager {

    static String fileName = "accounts.txt";

    static void save(ArrayList<BankAccount> accounts) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (BankAccount acc : accounts) {
                pw.println(acc.name + "," + acc.accountNumber + "," + acc.balance);

                // save transactions
                for (String t : acc.transactions) {
                    pw.println("TXN:" + t);
                }
                pw.println("END");  // marker for each account
            }
            System.out.println("Data saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving file!");
        }
    }

    static ArrayList<BankAccount> load() {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                String name = info[0];
                String accNo = info[1];
                double balance = Double.parseDouble(info[2]);

                BankAccount acc = new BankAccount(name, accNo, balance);

                while (!(line = br.readLine()).equals("END")) {
                    if (line.startsWith("TXN:")) {
                        acc.transactions.add(line.substring(4));
                    }
                }
                accounts.add(acc);
            }

            System.out.println("Data loaded successfully.");
        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
        }

        return accounts;
    }
}
