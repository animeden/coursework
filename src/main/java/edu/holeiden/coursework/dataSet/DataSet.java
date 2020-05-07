package edu.holeiden.coursework.dataSet;

import edu.holeiden.coursework.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataSet {
    private List<Administration> administrations = new ArrayList<>(Arrays.asList(
            new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"),
            new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                    "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову")
    ));

    private List<Brigade> brigades = new ArrayList<>(Arrays.asList(
            new Brigade("1", "Ремонтна", 9, new Department("1", "Перевезень", "Хмельницьк", new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
               LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),
            new Brigade("2", "Прибиральна", 11, new Department("2", "Перевезень", "Чернівці", new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                    "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті")
    ));

    private List<Department> departments = new ArrayList<>(Arrays.asList(
            new Department("1", "Перевезень", "Хмельницьк", new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
            new Department("2","Перевезень", "Чернівці", new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                    "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо")
    ));

    private List<Route> routes = new ArrayList<>(Arrays.asList(
            new Route("1", "Снятин" , "Чернівці", "Черемош,Запруття", "Пасажирське", LocalDateTime.now(), LocalDateTime.now(), "Довеземо"),
            new Route("2", "Хмельницьк" , "Запоріжжя", "Київ,Івано-Франківськ", "Грузове", LocalDateTime.now(), LocalDateTime.now(), "Вугілля")
    ));

    private List<Passenger> passengers = new ArrayList<>(Arrays.asList(
            new Passenger("1", "Придбано", new Route("1", "Снятин" , "Чернівці", "Черемош,Запруття", "Пасажирське", LocalDateTime.now(), LocalDateTime.now(), "Довеземо"), LocalDateTime.now(), LocalDateTime.now(), "Квиток"),
            new Passenger("2", "Придбано", new Route("2", "Хмельницьк" , "Запоріжжя", "Київ,Івано-Франківськ", "Грузове", LocalDateTime.now(), LocalDateTime.now(), "Вугілля"), LocalDateTime.now(), LocalDateTime.now(), "Квиток")
    ));

    private List<Worker> workers = new ArrayList<>(Arrays.asList(
            new Worker("1", "Петров Петро Петровий", "0632653455", "м.Снятин вул.Шевченка 12", "10.10.1986", "Касир", new Brigade("1", "Ремонтна", 9, new Department("1", "Перевезень", "Хмельницьк", new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"),
            new Worker("2", "Антонюк Марія Василівна", "9686326", "с.Чудо вул.Франка 16", "27.03.1899", "Добриво", new Brigade("2", "Прибиральна", 11, new Department("1", "Перевезень", "Чернівці", new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                    "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),LocalDateTime.now(), LocalDateTime.now(), "Не зробила курсову")
    ));

    private List<Train> trains = new ArrayList<>(Arrays.asList(
            new Train("1", "AC-49", new Brigade("1", "Ремонтна", 9, new Department("1", "Перевезень", "Хмельницьк", new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),
                    new Brigade("2", "Прибиральна", 11, new Department("1", "Перевезень", "Хмельницьк", new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                            "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                            LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"), LocalDateTime.now(), LocalDateTime.now(), "У чудовому стані"),
            new Train("2", "BD-2", new Brigade("1", "Ремонтна", 9, new Department("1", "Перевезень", "Чернівці", new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),
                    new Brigade("2", "Прибиральна", 11, new Department("1", "Перевезень", "Чернівці", new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                            "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                            LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"), LocalDateTime.now(), LocalDateTime.now(), "Поганюча розвалюха")
    ));

    private List<Ready> readies = new ArrayList<>(Arrays.asList(
            new Ready("1", new Train("1", "AC-49", new Brigade("1", "Ремонтна", 9, new Department("1", "Перевезень", "Хмельницьк", new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),
                    new Brigade("2", "Прибиральна", 11, new Department("1", "Перевезень", "Хмельницьк",new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                            "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                            LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"), LocalDateTime.now(), LocalDateTime.now(), "У чудовому стані"), "true", "true", "false", LocalDateTime.now(), LocalDateTime.now(), "Запаси їжі закінчилися(") ,
            new Ready("2", new Train("2", "BD-2", new Brigade("1", "Ремонтна", 9, new Department("1", "Перевезень", "Хмельницьк",new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),
                    new Brigade("2", "Прибиральна", 11, new Department("1", "Перевезень", "Хмельницьк",new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                            "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                            LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"), LocalDateTime.now(), LocalDateTime.now(), "Поганюча розвалюха"), "true", "true", "true", LocalDateTime.now(), LocalDateTime.now(), "Чух-чух-чух")
    ));

    private List<Timetable> timetables = new ArrayList<>(Arrays.asList(
            new Timetable("1", "19.00", "21.30",  new Route("1", "Снятин" , "Чернівці", "Черемош,Запруття", "Пасажирське", LocalDateTime.now(), LocalDateTime.now(), "Довеземо"), 1100 ,new Ready("1", new Train("1", "AC-49", new Brigade("1", "Ремонтна", 9, new Department("1", "Перевезень", "Хмельницьк",new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),
                    new Brigade("2", "Прибиральна", 11, new Department("1", "Перевезень", "Хмельницьк",new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                            "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                            LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"), LocalDateTime.now(), LocalDateTime.now(), "У чудовому стані"), "true", "true", "false", LocalDateTime.now(), LocalDateTime.now(), "Запаси їжі закінчилися(") , 50, 10, LocalDateTime.now(), LocalDateTime.now(), "Надто багато тексту(")  ,
            new Timetable("2", "17.00", "00.00",  new Route("2", "Хмельницьк" , "Запоріжжя", "Київ,Івано-Франківськ", "Грузове", LocalDateTime.now(), LocalDateTime.now(), "Вугілля"), 900 ,new Ready("2", new Train("2", "BD-2", new Brigade("1", "Ремонтна", 9, new Department("1", "Перевезень", "Хмельницьк",new Administration("1", "Голей Денис Богданович", "10.09.2001", "0683249831",
                    "м.Снятин вул.Гоголя 24", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 2, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                    LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"),
                    new Brigade("2", "Прибиральна", 11, new Department("1", "Перевезень", "Хмельницьк",new Administration("2", "Павлюк Надія Михайлівна", "15.01.2001", "0683249568",
                            "с.Семаківці вул.Дружби 1", LocalDateTime.now(), LocalDateTime.now(), "Робить курсову"), 0, LocalDateTime.now(), LocalDateTime.now(), "Працюємо"),
                            LocalDateTime.now(), LocalDateTime.now(), "Працьовиті"), LocalDateTime.now(), LocalDateTime.now(), "Поганюча розвалюха"), "true", "true", "true", LocalDateTime.now(), LocalDateTime.now(), "Чух-чух-чух") , 70, 4, LocalDateTime.now(), LocalDateTime.now(), "Тексту досі забагато!")
    ));

    public List<Administration> getAdministrations() {

        return administrations;
    }

    public void setAdministrations(List<Administration> administrations) {

        this.administrations = administrations;
    }

    public List<Brigade> getBrigades() {

        return brigades;
    }

    public void setBrigades(List<Brigade> brigades) {

        this.brigades = brigades;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Ready> getReadies() {
        return readies;
    }

    public void setReadies(List<Ready> readies) {
        this.readies = readies;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<Timetable> timetables) {
        this.timetables = timetables;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }
}
