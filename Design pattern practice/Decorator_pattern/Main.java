class Main{
    public static void main(String[] args) {
        Filereader file = new Simplereader();
        file = new Uppercase(file);
        file = new Compression(file);
        file = new Encryption(file);
        file = new Logging(file);


        file.read();
    }
}