

interface Filereader {
    void read();
}

class Simplereader implements Filereader {
    public void read(){
        System.out.println("This file just read ");
    }
}

class Advancereader implements Filereader{
    public void read(){
        System.out.println("here you can read and edit ");
    }
}
