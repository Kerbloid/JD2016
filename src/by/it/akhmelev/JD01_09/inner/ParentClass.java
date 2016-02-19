package by.it.akhmelev.JD01_09.inner;

/**
 * Created by Alex on 18.02.2016.
 */
public class ParentClass {
    // поля и конструкторы
    private SubClass eng;
    // abstract, final, private, protected - допустимы
    public class SubClass { // определение внутреннего (inner) класса
        // тут поля и методы
        public void launch() {
            System.out.println("SubClass работает");
        }
    } // конец объявления внутреннего класса

    public final void init() { // метод внешнего класса ParentClass
        System.out.println("init ParentClass");
        eng = new SubClass();
        eng.launch();
    }
}