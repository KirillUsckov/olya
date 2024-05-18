package org.example.db;


public class Controller {
    private static DBConnector connector = DBConnector.getInstance();
    private static Controller controller;

    private Controller(){
        connector.connect();
    }

    public static Controller getInstance() {
        if(controller == null)
            controller = new Controller();
        return controller;
    }

//    public void add() {
//        System.out.println("\nВведите данные поезда для добавления\n");
//        String number = getNumberOfTrainFromInput();
//        {
//            System.out.println(number);
//        }
//        Date date = getDepartureDateFromInput();
//        String arrival = getArrivalFromInput();
//        if(isTrainExist(new Train(number, null, date)))
//        {
//            System.out.println("Отправление с выбранным номером и датой уже существует");
//            return;
//        }
//        boolean wasAdded = connector.add(new Train(number, arrival, date));
//        String resultAdd = wasAdded ? "был": "не был";
//        System.out.println("Объект " + resultAdd +" добавлен");
//    }
//
//    public void delete() {
//        System.out.println("\nВведите данные поезда для удаления\n");
//        String number = getNumberOfTrainFromInput();
//        Date date = getDepartureDateFromInput();
//        if(connector.selectTrainsByParams(new Train(number, null, date)).isEmpty()) {
//            System.out.println("Такого отправления не существует, попробуйте еще раз");
//        }
//        else {
//            boolean wasDeleted = connector.delete(new Train(number, null, date));
//
//            String resultAdd = wasDeleted ? "был" : "не был";
//            System.out.println("Объект " + resultAdd + " удален");
//        }
//    }
//    public void showAll() {
//        List<Train> trains = connector.selectAll();
//        if(trains.isEmpty())
//        {
//            System.out.println("Отправления не были найдены");
//            return;
//        }
//        Collections.sort(trains);
//        System.out.println("№\tДата\t\t\t\tГород");
//        trains.forEach(System.out::println);
//    }
//
//    public void show() {
//        System.out.println("\nВыберите данные для поиска\n");
//
//        boolean showByNumber = getBooleanResponse("Номер поезда");
//        String number = null;
//        if(showByNumber) {
//            number = getNumberOfTrainFromInput();
//        }
//
//        boolean showByDepDate = getBooleanResponse("Дата отправления");
//        Date depDate = null;
//        if(showByDepDate) {
//            depDate = getDepartureDateFromInput();
//        }
//
//        boolean showByArrival = getBooleanResponse("Место прибытия");
//        String arrival = null;
//        if(showByArrival) {
//            arrival = getArrivalFromInput();
//        }
//
//        if(!showByNumber&&!showByArrival&&!showByDepDate) {
//            if(getBooleanResponse("Не был выбран не один фильтр. Показать все отправления"))
//                showAll();
//        }
//        else {
//            List<Train> trains = connector.selectTrainsByParams(new Train(number, arrival, depDate));
//            if(trains.isEmpty()) {
//                System.out.println("Поезда по выбранным фильтрам не были найдены");
//                return;
//            }
//            System.out.println("\nСписок поездов по выбранным фильтрам\n");
//            System.out.println("№\tДата\t\t\t\tГород");
//            Collections.sort(trains);
//            trains.forEach(System.out::println);
//        }
//    }
//
//    public boolean isTrainExist(Train train) {
//        return !connector.selectTrainsByParams(train).isEmpty();
//    }
//
//    public void update() {
//        System.out.println("\nВведите данные поезда, который будет изменен\n");
//        String oldNumber = getNumberOfTrainFromInput();
//        Date oldDate = getDepartureDateFromInput();
//
//        if(connector.selectTrainsByParams(new Train(oldNumber, null, oldDate)).isEmpty()) {
//            System.out.println("Такого отправления не существует, попробуйте еще раз");
//        }
//
//        String arrival = connector.selectTrainsByParams(new Train(oldNumber, null, oldDate)).get(0).getArrival();
//
//        boolean willNumberBeEdited = getBooleanResponse("Номер поезда будет изменен");
//        String newNumber = null;
//        if(willNumberBeEdited) {
//            newNumber = getNumberOfTrainFromInput();
//        }
//
//        boolean willDepartureDateBeEdited = getBooleanResponse("Дата отправления будет изменена");
//        Date newDepDate = null;
//        if(willDepartureDateBeEdited) {
//            newDepDate = getDepartureDateFromInput();
//        }
//
//        boolean willArrivalBeEdited = getBooleanResponse("Место прибытия будет изменено");
//        String newArrival = null;
//        if(willArrivalBeEdited) {
//            newArrival = getArrivalFromInput();
//        }
//
//        if(isTrainExist(new Train(newNumber,  null, newDepDate)))
//            System.out.println("Поезд с такими данными уже существует\nПопробуйте еще раз");
//        else {
//            boolean wasUpdated = connector.update(
//                    new Train(oldNumber, arrival, oldDate),
//                    new Train(newNumber,  newArrival, newDepDate));
//
//            String resultAdd = wasUpdated ? "был" : "не был";
//            System.out.println("Объект " + resultAdd + " обновлен");
//        }
//    }
}
