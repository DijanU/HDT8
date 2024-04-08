public class Paciente implements Comparable<Paciente> {
    private String name;
    private String condition;
    private String priority;

    public Paciente(String name, String condition, String priority) {
        this.name = name;
        this.condition = condition;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Paciente other) {

        String priorityOrder = "ABCDE";
        int thisPriorityIndex = priorityOrder.indexOf(this.priority.toUpperCase());
        int otherPriorityIndex = priorityOrder.indexOf(other.getPriority().toUpperCase());

        return Integer.compare(thisPriorityIndex, otherPriorityIndex);
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "name='" + name + '\'' +
                ", condition='" + condition + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

}
