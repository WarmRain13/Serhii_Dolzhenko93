
public class Loader
{
    public static void main(String[] args)
    {
        Cat cat1 = new Cat();
        cat1.getWeight();
        System.out.println("cat1 weight: " + cat1.getWeight());
        System.out.println("количество кошек" + " " + Cat.getCount());

        while (cat1.isAlive()) {

            System.out.println(cat1.getWeight());
            cat1.feed(5.5);
        }
        System.out.println(cat1.getStatus());
        System.out.println("количество кошек" + " " + Cat.getCount());

        Cat cat2 = new Cat();
        cat2.getWeight();
        cat2.setName("Барсик");
        cat2.setColour(Colour.BROWN);
        System.out.println("Имя кота2 " + cat2.getName());
        System.out.println("Вес кота2: " + cat2.getWeight());
        System.out.println("Цвет кота2 " + cat2.getColour());
        System.out.println("количество кошек" + " " + Cat.getCount());

        while (!cat2.getStatus().equals("Dead")) {

            System.out.println(cat2.getWeight());
            cat2.meow();
        }
        System.out.println(cat2.getStatus());
        System.out.println("количество кошек" + " " + Cat.getCount());

        Cat cat3 = new Cat();
        cat3.getWeight();
        System.out.println("cat3 weight: " + cat3.getWeight());
        System.out.println("количество кошек" + " " + Cat.getCount());

        Cat cat4 = new Cat();
        cat4.getWeight();
        System.out.println("cat4 weight: " + cat4.getWeight());
        System.out.println("количество кошек" + " " + Cat.getCount());

        Cat cat5 = new Cat();
        cat5.getWeight();
        System.out.println("cat5 weight: " + cat5.getWeight());
        System.out.println("количество кошек" + " " + Cat.getCount());

        //Урок 2

        Cat vasya = new Cat();
        System.out.println(vasya.getWeight());
        vasya.feed(150.0);
        vasya.feed(100.0);
        vasya.pee();
        vasya.pee();
        System.out.println(vasya.getWeight());
        System.out.println("всего корма съедено" + " " + vasya.FeedAmount());
        System.out.println("количество кошек" + " " + Cat.getCount());

        //Урок 3 переменная count

        Cat musya = new Cat();
        System.out.println(musya.getWeight());
        System.out.println("количество кошек" + " " + Cat.getCount());


        //Урок 5 Создание объектов и конструкторов

       Cat dusya = getKitten();
        System.out.println(dusya.getStatus());
        System.out.println(dusya.getWeight());
        System.out.println("количество кошек" + " " + Cat.getCount());

       Cat masha = getKitten();
        System.out.println(masha.getStatus());
        System.out.println(masha.getWeight());
        System.out.println("количество кошек" + " " + Cat.getCount());

       Cat varya = getKitten();
        System.out.println(varya.getStatus());
        System.out.println(varya.getWeight());
        System.out.println("количество кошек" + " " + Cat.getCount());

        //Урок 6

        musya.setColour(Colour.WHITE);
        System.out.println("Цвет Муси " + musya.getColour());

        //Урок 7

        Cat cat7 = new Cat(cat2);
        System.out.println("Имя кота2 " + cat2.getName());
        System.out.println("Вес кота2: " + cat2.getWeight());
        System.out.println("Цвет кота2 " + cat2.getColour());
        System.out.println(cat2.getStatus());

        System.out.println("Имя кота7 " + cat7.getName());
        System.out.println("Вес кота7: " + cat7.getWeight());
        cat7.setName("Шишка");
        cat7.setColour(Colour.BLACK);
        cat7.feed(100.0);
        System.out.println("Изменили вес кота7 на: " + cat7.FeedAmount());
        System.out.println("Переименовали кота7 на " + cat7.getName());
        System.out.println("Вес кота7: " + cat7.getWeight());
        System.out.println("Цвет кота7: " + cat7.getColour());
        System.out.println(cat7.getStatus());
        System.out.println(cat7.getMaxWeight());
        System.out.println(cat2.getMaxWeight());


    }

    private static Cat getKitten()
    {
        return new Cat(1100);
    }
}