public abstract class Decoratorfile implements Filereader {
    protected Filereader file;
    Decoratorfile(Filereader file){
        this.file = file;
    }

    public abstract void read();
}

class Compression extends Decoratorfile{

    Compression(Filereader file){
        super(file);
    }

    public void read(){
        file.read();
        System.out.println(", Compression handling");
    }
}

class Encryption extends Decoratorfile{

    Encryption(Filereader file){
        super(file);
    }

    public void read(){
        file.read();
        System.out.println(", Encryption handling");
    }
}
class Logging extends Decoratorfile{

    Logging(Filereader file){
        super(file);
    }

    public void read(){
        file.read();
        System.out.println( ", Logging");
    }
}

class Uppercase extends Decoratorfile{

    Uppercase (Filereader file){
        super(file);
    }

    public void read(){
        file.read();
        System.out.println( ", Uppercase transformation");
    }
}
