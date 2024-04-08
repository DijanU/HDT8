/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * HT8, heap y priorityQueue
 * 08-04-2024
 * @HEAP
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HEAP<E extends Comparable<E>> {

    private VectorHeap<Paciente> heap;

    public HEAP() {
        heap = new VectorHeap<>();
    }

    public void add(String name, String condition, String priority) {
        Paciente paciente = new Paciente(name, condition, priority);
        heap.add(paciente);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public Paciente poll() {
        return heap.poll();
    }

    public static void main(String[] args) {
        String database = "pacientes.txt";
        HEAP<String> tree = new HEAP<>();
        
        // CSV reader
        try (BufferedReader br = new BufferedReader(new FileReader(database))) {
            String encabezado = br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] valores = linea.split(",");
                String name = valores[0].trim();
                String condition = valores[1].trim();
                String priority = valores[2].trim();
                tree.add(name, condition, priority);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        while (!tree.isEmpty()) {
            // Obtener el próximo paciente de la cola de prioridad
            Paciente nextPatient = tree.poll();
            System.out.println("Heap");
            // Mostrar la información del paciente
            System.out.println("Siguiente paciente:");
            System.out.println("Nombre: " + nextPatient.getName());
            System.out.println("Síntoma: " + nextPatient.getCondition());
            System.out.println("Prioridad: " + nextPatient.getPriority());
            
            // Preguntar si el médico desea ver al siguiente paciente
            System.out.println("¿Desea ver al siguiente paciente? (S/N)");
            String response = scanner.nextLine().trim();
            
            // Si la respuesta es "N", salir del bucle
            if (response.equalsIgnoreCase("N")) {
                break;
            }
        }
        scanner.close();
    }
}
