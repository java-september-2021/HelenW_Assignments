

public class Project {
    private String name;
    private String description;
    private double initialCost = 0;
    private static String defaultName = "defaultName";
    private static String defaultDesc = "defaultDesc";

    //getter 
    public String getName() {
        return this.name;
    }
    public String getDesc() {
        return this.description;
    }
    public Double getInitialCost() {
        return this.initialCost;
    }
    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setDesc(String description) {
        this.description = description;
    }
    public void setInitialCost(double newInitalCost) {
        this.initialCost = newInitalCost;
    }

    public Project() {
        this.name = defaultName;
        this.description = defaultDesc;

    }
    public Project (String name) {
        this.name = name;
        this.description = defaultDesc;
    }
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String elevatorPitch() {
        return "Name is "+this.name+"("+this.initialCost+")"+": " +this.description;
    }

    
}
