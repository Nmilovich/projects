

import javax.swing.plaf.IconUIResource;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        File file = new File("/home/nikolas/Рабочий стол/1.text");
        List<Person> listPerson = new ArrayList<>();
        List<String> recordingList = Arrays.asList(
                "Куимов Аркадий",
                "Клименко Назар",
                "Бореев Кир",
                "    ",
                "Созонтов Мартьян",
                "Негес Игнат",
                "Шеломов Капитон",
                "Рокоссовский Арсений",
                "Яловкин Федор",
                "Хмельнов Якуб",
                "Свалов Макар",
                "Ельченко Федосий",
                "Килик Роман",
                "Саньков Радислав",
                "Славаков Андрон",
                "Щукин Агафон",
                "Пшеничников Ростислав",
                "Ямалетдинов Кондратий",
                "Михалицин Феликс",
                "Целобанов Емельян");




        Factory.getFactory().writerPerson(recordingList, file);
        Factory.getFactory().readerPerson(listPerson,file);


        Constructor<Factory> constructor = Factory.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Factory otherSingleton = constructor.newInstance();

        /*try {
            Constructor<Factory> constructor = Factory.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Factory otherSingleton = constructor.newInstance();
        } catch (LimitObjectsException e) {
            throw new InvocationTargetException(e);
        }*/





        System.out.println(listPerson);


// Создаём второй объект через рефлексию




    }
}
