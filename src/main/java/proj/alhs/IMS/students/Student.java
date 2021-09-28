package proj.alhs.IMS.students;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer itemsReserved;

    public Student() {
    }

    public Student(Long id, String firstName, String lastName, Integer itemsReserved) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.itemsReserved = itemsReserved;
    }

    public Student(String firstName, String lastName, Integer itemsReserved) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.itemsReserved = itemsReserved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getItemsReserved() {
        return itemsReserved;
    }

    public void setItemsReserved(Integer itemsReserved) {
        this.itemsReserved = itemsReserved;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", itemsReserved=" + itemsReserved +
                '}';
    }
}
