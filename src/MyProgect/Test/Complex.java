package MyProgect.Test;

class Complex  {
    static int counter=0;
    double Re, Im;
    int  number;
    Complex Sum(Complex obj){
        System.out.println("Суммирование вашего числа с числом № "+obj.number);
        Complex tmp = new Complex();
        tmp.Re=Re+obj.Re;
        tmp.Im=Im+obj.Im;

        return tmp;
    }

    Complex Divide(Complex obj) {
        System.out.println("Деление вашего числа на число № "+obj.number);
        if(obj.Im==0||obj.Re==0){
            throw new ArithmeticException();

        }
        else{
            Complex tmp = new Complex();
            tmp.Re=obj.Re/Re;
            tmp.Im=obj.Im/Im;
            return tmp;}

    }


    Complex Multi(Complex obj){
        System.out.println("Умножение вашего числа на число № "+obj.number);
        Complex tmp=new Complex();
        tmp.Im=Im*obj.Re+Re*obj.Im;
        tmp.Re=Re*obj.Re-Im*obj.Im;
        return tmp;
    }



    void show(Complex obj){
        System.out.println("Число № "+number);
        System.out.println("Действительная часть = "+Re);
        System.out.println("Мнимая часть = "+Im);
    }
    Complex() {
        counter++;
        number=counter;
        Re=0;
        Im=0;
    }
    Complex(double x){
        counter++;
        number=counter;
        Re=x;
        Im=0;
    }

    Complex(Complex obj){
        counter++;
        number=counter;
        Re=obj.Re;
        Im=obj.Im;
    }
    @Override
    public String toString() {
        return "Complex{" + "Re=" + Re + ", Im=" + Im + ", number=" + number + '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Complex other = (Complex) obj;
        if (Double.doubleToLongBits(this.Re) != Double.doubleToLongBits(other.Re)) {
            return false;
        }
        if (Double.doubleToLongBits(this.Im) != Double.doubleToLongBits(other.Im)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
