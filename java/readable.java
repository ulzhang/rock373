interface Readable {
    public void printTitle();
}


class WebText implements Readable {
    public String title;
    public void printTitle(){
        System.out.println("The webpage titles is: " + title);
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

class Blog extends WebText{
    public void printTitle(){
        System.out.println("The Blog titles is: " + title);
    }
}

class ReadingTester {
    public static void main (String [] args) {
        Blog b1 = new Blog();
        WebText b2 = new Blog();

        b1.setTitle("How to upcast");
        b2.setTitle("Dangers of upcasting");

        b1.printTitle();
        b2.printTitle();
    }
}