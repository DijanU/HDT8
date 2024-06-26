/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * HT8, heap y priorityQueue
 * 08-04-2024
 * @PacientePQ
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PacientePQ implements Comparable<PacientePQ> {
    private String name;
    private String condition;
    private String priority;

    public PacientePQ(String name, String condition, String priority) {
        this.name = name;
        this.condition = condition;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public String getCondition() {
        return condition;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PacientePQ other) {
        
        return this.priority.compareTo(other.getPriority());
    }

    public static void main(String[] args) {
        String database = "pacientes.txt";
        PriorityQueue<PacientePQ> heap = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String encabezado = br.readLine(); 
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                String name = valores[0].trim();
                String condition = valores[1].trim();
                String priority = valores[2].trim();
                PacientePQ paciente = new PacientePQ(name, condition, priority);
                heap.add(paciente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (!heap.isEmpty()) {
            PacientePQ nextPatient = heap.poll();
            System.out.println("Priority Queue");
            System.out.println("Siguiente paciente:");
            System.out.println("Nombre: " + nextPatient.getName());
            System.out.println("Síntoma: " + nextPatient.getCondition());
            System.out.println("Prioridad: " + nextPatient.getPriority());

            System.out.println("¿Desea ver al siguiente paciente? (S/N)");
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }
        scanner.close();
    }
}
