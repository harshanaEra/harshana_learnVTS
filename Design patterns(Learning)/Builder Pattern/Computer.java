package BuilderPattern;

public class Computer {

    private String brand;
    private String model;
    private String proc;
    private String ram;
    private String ssd;
    private String gpu;

    public Computer(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.proc =  builder.proc;
        this.ram = builder.ram;
        this.ssd = builder.ssd;
        this.gpu = builder.gpu;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProc() {
        return proc;
    }

    public void setProc(String proc) {
        this.proc = proc;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getGpu() {
        return gpu;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", proc='" + proc + '\'' +
                ", ram='" + ram + '\'' +
                ", ssd='" + ssd + '\'' +
                ", gpu='" + gpu + '\'' +
                '}';
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    static class Builder{
        private String brand;
        private String model;
        private String proc;
        private String ram;
        private String ssd;
        private String gpu;

        public Computer build(){
            return new Computer(this);
        }

        public Builder setBrand(String brand){
            this.brand = brand;
            return this;
        }

        public Builder setModel(String model){
            this.model = model;
            return this;
        }

        public Builder setProc(String proc){
            this.proc = proc;
            return this;
        }

        public Builder setRam(String ram){
            this.ram = ram;
            return this;
        }

        public Builder setSsd(String ssd){
            this.ssd = ssd;
            return this;
        }

        public Builder setGpu(String gpu){
            this.gpu = gpu;
            return this;
        }

    }
}