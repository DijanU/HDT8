/** Algoritmos y Estructuras de datos -  seccion 30
 * Luis Francisco Padilla Juárez - 23663
 * HT8, heap y priorityQueue
 * 08-04-2024
 * @Association
 */
public class Association<K extends Comparable<K>, T> implements Comparable<Association<K, T>>{
    public K key;
    public T data;
    public Association(K cKey, T cData){
        this.key = cKey;
        this.data = cData;
    }
    public int compareTo(Association<K, T> other){
        return this.key.compareTo(other.key);
    }
    public String toString(){
        return key.toString() + ":" + data.toString();
    }
}
