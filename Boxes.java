//********************************************************************************************************
//3. Большая задача:
//        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
//        поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//        d. Сделать метод getWeight() который высчитывает вес коробки,
//        зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
//        которую подадут в compare в качестве параметра, true - если их веса равны,
//        false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
//        (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
//        соответственно в текущей коробке фруктов не остается, а
//        в другую перекидываются объекты, которые были в этой коробке;
//        g. Не забываем про метод добавления фрукта в коробку.
//********************************************************************************************************

import java.util.ArrayList;

public class Boxes {
//склад ящиков
    private static ArrayList<Box> boxes = new ArrayList<>();


    public static void main(String[] args)   {
   //     Box box = new Box( new Apple(), 30);

 //       System.out.println(box.getWeight());

        boxes.add(new Box(new Apple(), 50));
        boxes.add(new Box(new Orange(), 70));
        boxes.add(new Box(new Orange(), 100));
        boxes.add(new Box(new Apple(), 50));
        boxes.add(new Box(new Orange(), 50));
        boxes.add(new Box());
        boxes.get(5).add(new Apple(), 40);
        boxes.get(5).add(new Orange(), 50);
        boxes.get(5).add(new Apple(), 10);

        System.out.println(boxes.get(0).compare(boxes.get(4)));
        System.out.println(boxes.get(0).compare(boxes.get(1)));
        System.out.println(boxes.get(0).compare(boxes.get(3)));

        transfer(0,1);
        transfer(0, 3);
        System.out.println(boxes.get(0).toString());
        System.out.println(boxes.get(1).toString());
        System.out.println(boxes.get(2).toString());
        System.out.println(boxes.get(3).toString());
        System.out.println(boxes.get(4).toString());
        System.out.println(boxes.get(5).toString());



    }
//пересыпка  ящика внутри    склада
    public static  void  transfer(int indexFrom, int indexTo)  {
        try {
            boxes.set(indexTo, boxes.get(indexFrom).moveTo(boxes.get(indexTo)));
        } catch (TransferExeption transferExeption) {
            transferExeption.printStackTrace();
        }
    }

}


class Box  {
    private Fruct sort;
    private Integer amount = 0;
//пустой ящик
    public Box() {
    }
// наполненный ящик
    public Box(Fruct sort, Integer amount) {
        this.sort = sort;
        this.amount = amount;
    }

    public Fruct getSort() {
        return sort;
    }

    public void setSort(Fruct sort) {
        this.sort = sort;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
        if (this.amount < 0) this.amount = 0;
    }
//вес ящика
    Double getWeight() {
        return (double) this.sort.getMass() * this.amount;
    }

//сравнение   веса ящиков
    boolean compare (Box box) {
        if (Math.abs(this.getWeight() - box.getWeight()) < 0.01) return true;
        return false;
    }

    Box moveTo (Box box) throws TransferExeption {
        if (!this.sort.getSort().equals(box.sort.getSort())) throw  new TransferExeption("Sorts are different");
//        if (box.sort instanceof  this.sort) throw  new TransferExeption("Sorts are different");
        // проверку   типов  через истанс оа  не удается успешно провести, компилятортне пускает.
        // реализовано через с сравнение строковых значений сорта

        box.amount = box.amount + this.amount;
        this.amount = 0;
        return box;
    }
//метод добавления    фруктов в пустой  ящик
    void add (Fruct sort, Integer amount) {
        try {
            if (this.sort != null && !this.sort.getSort().equals(sort.getSort()))
            throw  new TransferExeption("The box  is not empty");
            setSort(sort);
            setAmount(this.amount + amount);
        } catch (TransferExeption transferExeption) {
            transferExeption.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Box{" +
                "sort=" + sort +
                ", amount=" + amount +
                '}';
    }

}

//Класс, который обрабатывает исключения   разносортицы
class  TransferExeption extends Throwable {
    /**
     * Constructs a new throwable with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * <p>The {@link #fillInStackTrace()} method is called to initialize
     * the stack trace data in the newly created throwable.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public TransferExeption(String message) {
        System.out.println(message);
    }
}

abstract class Fruct {
      private String sort;
      private float mass;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return  sort;
    }
}

class Apple extends Fruct {

    public Apple() {
        super();
        setSort("APPLE");
        setMass(1.0f);
    }
}

class Orange extends Fruct{
    public Orange() {
        super();
        setSort("ORANGE");
        setMass(1.5f);
    }
}

//class Empty extends Fruct {
//    public Empty() {
//        super.sort = "EMPTY";
//        super.mass = 0f;
//    }
//}