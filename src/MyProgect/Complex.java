package MyProgect;

class Complex {
    // Объявление переменных
    int real, imaginary;
    // Пустой конструктор
    Complex()
    {
    }
    // Конструктор для принятия
    // реальная и мнимая часть
    Complex(int tempReal, int tempImaginary)
    {
        real = tempReal;
        imaginary = tempImaginary;
    }
    // Определение метода addComp ()
    // для сложения двух комплексных чисел
    Complex addComp(Complex C1, Complex C2)
    {
        // создаем временную переменную
        Complex temp = new Complex();
        // добавляем вещественную часть комплексных чисел
        temp.real = C1.real + C2.real;
        // добавление мнимой части комплексных чисел
        temp.imaginary = C1.imaginary + C2.imaginary;
        // возвращаем сумму
        return temp;
    }
    // Определение метода subtractComp ()
    // для вычитания двух комплексных чисел
    Complex subtractComp(Complex C1, Complex C2)
    {
        // создаем временную переменную
        Complex temp = new Complex();
        // вычитаем вещественную часть комплексных чисел
        temp.real = C1.real - C2.real;
        // вычитаем мнимую часть комплексных чисел
        temp.imaginary = C1.imaginary - C2.imaginary;
        // возвращаем разницу
        return temp;
    }
    // Функция для печати комплексного номера
    void printComplexNumber()
    {
        System.out.println("Complex number: "
                + real + " + "
                + imaginary + "i");
    }
}


