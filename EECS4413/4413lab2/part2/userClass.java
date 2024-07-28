public class userClass {
    
    private String name;
    private String type;

    public userClass(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    @Override
    public String toString(){
        return this.name + " " + this.type + "\n";
    }
}
