package PrakritiAcharya_sec002_ex01;

import java.util.*;
import java.util.stream.*;

public class InvoiceTest {
    public static void main(String[] args) {
        List<Invoice> invoices = Arrays.asList(
            new Invoice("87", "Electric Sander", 7, 57.08),
            new Invoice("24", "Power Saw", 18, 99.99),
            new Invoice("7", "Sledge Hammer", 11, 21.50),
            new Invoice("77", "Hammer", 76, 11.99),
            new Invoice("39", "Lawn Mower", 3, 79.50),
            new Invoice("68", "Screw Driver", 106, 6.99),
            new Invoice("56", "Jig Saw", 21, 11.0)


        );

        // a) Sort by partDescription
        System.out.println("Sorted by Part Description:");
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);

        // b) Sort by pricePerItem
        System.out.println("\nSorted by Price Per Item:");
        invoices.stream()
                .sorted(Comparator.comparing(Invoice::getPricePerItem))
                .forEach(System.out::println);

        // c) Map to partDescription and quantity, sort by quantity
        System.out.println("\nSorted by Quantity:");
        invoices.stream()
                .map(invoice -> new AbstractMap.SimpleEntry<>(invoice.getPartDescription(), invoice.getQuantity()))
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .forEach(System.out::println);

        // d) Map to partDescription and Invoice value, order by Invoice Value
        System.out.println("\nOrdered by Invoice Value:");
        invoices.stream()
                .map(invoice -> new AbstractMap.SimpleEntry<>(invoice.getPartDescription(), invoice.getInvoiceValue()))
                .sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);

        // e) Invoice values in range $200 to $500
        System.out.println("\nInvoice Values in Range $200 to $500:");
        invoices.stream()
                .filter(invoice -> invoice.getInvoiceValue() >= 200 && invoice.getInvoiceValue() <= 500)
                .forEach(System.out::println);

        // f) Find invoice with partDescription containing "saw"
        System.out.println("\nInvoice containing 'saw':");
        invoices.stream()
                .filter(invoice -> invoice.getPartDescription().toLowerCase().contains("saw"))
                .findFirst()
                .ifPresent(System.out::println);
    }
}

