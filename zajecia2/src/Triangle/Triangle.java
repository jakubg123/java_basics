package Triangle;

public class Triangle {
    private int a,b,c;
    public Triangle(int a, int b, int c){

        this.a = a;
        this.b = b;
        this.c = c;
       if(!isTriangle()){
           throw new IllegalArgumentException("Cant create that object");
       }
    }
    public int calculateArea(){
        return (a * b * c) / 2;
    }


    public int calculatePerimiter(){
        return a + b + c;
    }

    public String getType(){
       if(a == b && a == c){
           return "rownoboczny";
       }
       else if(a != b && a != c && b != c){
           return "roznoboczny";
       }
       else{
           return "rownoramienny";
       }

    }

    public boolean isTriangle() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }



}
