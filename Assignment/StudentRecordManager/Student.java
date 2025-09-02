package StudentRecordManager;


public final class Student{
    private final long id;
    private final String fullName;
    private final String bloodGroup;
    private final float cgpa;

    public Student(long id, String fullName, String bloodGroup, float cgpa){
        this.id = id;
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
        this.cgpa = cgpa;
    }

    public long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getBloodGroup() {
        return bloodGroup;  
    }
    public float getCgpa() {
        return cgpa;
    }

    public void printInfo(){
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("CGPA: " + cgpa);
        System.out.println();
    }

    public boolean matchQuery(String query){
        String[] parts = fullName.split(" ");
        String lastName;

        if(parts.length > 1){
            lastName = parts[parts.length - 1];
        } else {
            lastName = fullName;
        }

        return lastName.equalsIgnoreCase(query) || bloodGroup.equalsIgnoreCase(query);  
    }
}