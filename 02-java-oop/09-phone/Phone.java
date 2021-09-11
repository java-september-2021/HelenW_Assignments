import jdk.internal.jshell.tool.resources.version;

public abstract class Phone {
    private String versionNumber;
    private int batteryPercentage;
    private String carrier;
    private String ringTone;
    public Phone(String versionNumber, int batteryPercentage, String carrier, String ringTone){
        this.versionNumber = versionNumber;
        this.batteryPercentage = batteryPercentage;
        this.carrier = carrier;
        this.ringTone = ringTone;
    }
    // abstract method. This method will be implemented by the subclasses
    public abstract void displayInfo();
    // getters and setters removed for brevity. Please implement them yourself
    //getter
    public String getVersionNumber() {
        return this.versionNumber;
    }
    public int getBatteryPercentage() {
        return this.batteryPercentage;
    }
    public String getCarrier() {
        return this.carrier;
    }
    public String getRingtone() {
        return this.ringTone;
    }
    //setter
    public void setVersionNumber(String versionNum) {
        this.versionNumber = versionNum;
    }
    public void setBatteryPercentage(int percentage) {
        this.batteryPercentage= percentage;
    }
    public void setCarrier(String someCarrier) {
        this.carrier = someCarrier;
    }
    public void setRingTone(String someTone) {
        this.ringTone = someTone;
    }
}

