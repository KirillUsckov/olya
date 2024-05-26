[Полезные инструкции](#-------------------)
  - [MySQL](#mysql)
    + [Для уставноки дампа необходимо перейтив MySQL Shell, и ввести команду:](https://github.com/KirillUsckov/olya/tree/main#%D0%BF%D0%B0%D1%82%D1%82%D0%B5%D1%80%D0%BD%D1%8B)
    + [Для создания дампа БД переходим в командную строку и вводим:](https://github.com/KirillUsckov/olya/tree/main#%D0%BF%D0%B0%D1%82%D1%82%D0%B5%D1%80%D0%BD%D1%8B)

[Теория общая](https://github.com/KirillUsckov/olya/tree/main#%D1%82%D0%B5%D0%BE%D1%80%D0%B8%D1%8F-%D0%BE%D0%B1%D1%89%D0%B0%D1%8F)
  - [Паттерны](https://github.com/KirillUsckov/olya/tree/main#%D0%BF%D0%B0%D1%82%D1%82%D0%B5%D1%80%D0%BD%D1%8B)
    + [Singleton](#singleton)

[Java](#java)
  - [Интефейсы vs Абстрактные классы](https://github.com/KirillUsckov/olya/tree/main#%D0%BF%D0%B0%D1%82%D1%82%D0%B5%D1%80%D0%BD%D1%8B)


# Полезные инструкции
## MySQL 
### Импорт дампа
1. Открыть MySql CommandLine
2. Ввести команду ```create database name_of_db;```
3. Открыть командную строку от мени администратора
4. Ввести команду ```mysql -u username -p name_of_db < full_path_to_dump```

После чего ввести пароль от root

### Для создания дампа БД переходим в командную строку и вводим:
```mysqldump -v -h 127.0.0.1 -u root -p название_бд_которую_хотим_выгрузить > путь_к_дампу```

# Теория общая 

## Паттерны

### Singleton
Cинглтон (Одиночка) — это шаблон (паттерн) проектирования, который делает две вещи:
- Дает гарантию, что у класса будет всего один экземпляр класса.
- Предоставляет глобальную точку доступа к экземпляру данного класса.

Отсюда — две особенности, характерные для практически каждой реализации паттерна синглтон: 
- Приватный конструктор. Ограничивает возможность создания объектов класса за пределами самого класса.
- Публичный статический метод, который возвращает экземпляр класса. Данный метод называют getInstance. Это глобальная точка доступа к экземпляру класса.

Пример реализации (не потокобезопасная):
```Java
public class Singleton {
  private static Singleton INSTANCE;

  private Singleton() {}

  public static Singleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new Singleton();
    }
    return INSTANCE;
  }
}
```

Пример реализации (потокобезопасная):
```Java
public class Singleton {
    private static Singleton INSTANCE;

  private Singleton() {
  }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
```

# Java

## Интефейсы vs Абстрактные классы

| Характеристика | Абстрактный класс | Интерфейс |
| ------ | ------ | ------ |
| Наследование/Имплементация|наследуется только 1 класс|наследуется сколько угодно|
|Реализация методов|есть (обычные)| есть (с ключевым словом default - он не может быть статическим)|
Методы без реализации| есть (с ключевым словом abstract)|есть (обычные)|
|Переменные|любые|только неизменяемые (необязательно писать, что они final static - это их дефолтное состояние в интерфейсе)|
|Когда использовать| - Если нужно изменяемое состояние (переменные) <br>- Если нужен базовый класс для объектов 1 группы | - Если хранить состояние класса не нужно <br>- Если нужно описать только поведение (не обязательно для объектов 1 группы, как, например Comparator)|
|Расширение|может быть расширен интерфейсом или классом (```public abstract class Cat extends Cat1 implements Comparator```)|может быть расширен только другим интерфейсом (```public interface Runnable extends Iterable```)|
