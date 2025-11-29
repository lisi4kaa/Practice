# Практическое задание по Git/GitHub

**Студент:** Асветимская Елизавета  
**Курс:** 2

## Последовательность выполнения:
```bash
    1  ssh-keygen
    2  git config --global usesr.name "Асветимская Елизавета"
    3  git config --global usesr.email "lisa.asvetimskaya@gmail.com"
    4  git config --global core.editor "code --wait"
    5  git config --list
    # Исправление опечатки в настройках
    6  git config --global --unset usesr.name
    7  git config --global --unset usesr.email
    8  git config --global user.name "Асветимская Елизавета"
    9  git config --global user.email "lisa.asvetimskaya@gmail.com"
    # Проверка настроек
   10  git config --list
    # Настройка ssh подключения к Github
   11  ssh-keygen -t ed25519 -C "lisa.asvetimskaya@gmail.com"
   12  ssh-keygen -t ed25519 -C "lisa.asvetimskaya@gmail.com"
   13  eval "$(ssh-agent -s)"
   14  ssh-add~/.ssh/id_ed25519
   15  ssh-add ~/.ssh/id_ed25519
   16  cat ~/.ssh/id_ed_ed25519.pub
   # Исправление опечатки
   17  cat ~/.ssh/id_ed25519.pub
   18  ssh -T git@github.com
   19  yes
   20  ssh -o StrictHostKeyCheking=no -T git@github.com
   21  ssh -o StrictHostKeyChecking=no -T git@github.com
   22  cat ~/.ssh/id_ed25519.pub
    # Проверка подключения к GitHub
   23  ssh -T git@github.com
   # Создание и настройка репозитория
   24  mkdir Practice
   25  cd Practice
   26  get init
   27  git init
   28  git branch
   # Добавление информации о студенте
   29  echo "Выполнила Асветимская Елизавета" > student_info.txt
   30  git add student_info.txt
   31  git commit -m "Добавлена информация о студенте"
   # Подключение удаленного репозитория (с опечаткой)
   32  git remote add orgin git@github.com:lisi4kaa/Practice.git
   33  git branch -M main
   34  git push -u origin main
   # Исправление опечатки и настройка подключения
   35  git remote add origin git@github.com:lisi4kaa/Practice.git
   36  git remote remove orgin
   # Первая отправка изменений на GitHub
   37  git push -u origin main
   # Проверка подключения
   38  git remote -v
   # Создание веток для каждого задания
   39  git checkout homework1
   40  git checkout -b homework1
   41  mkdir timeModule
   # Добавление Java классов для работы с часами и сменой модулей времени
   42  cp "/c/JavaProjects/Modsen/src/MainProgramm.java" timeModule/
   43  git add timeModule/MainProgramm.java
   44  git commit -m "Добавлен оснновной класс программы"
   45  cp "/c/JavaProjects/Modsen/src/Time12Module.java" timeModule/
   46  git add timeModule/Time12Module.java
   47  git commit -m "Добавлен модуль 12 часового формата"
   48  cp "/c/JavaProjects/Modsen/src/Time24Module.java" timeModule/
   49  git add timeModule/Time24Module.java
   50  git commit -m "Добавлен модуль 24 часового формата"
   51  cp "/c/JavaProjects/Modsen/src/TimeModule.java" timeModule/
   52  git add timeModule/TimeModule.java
   53  git commit -m "Добавлен общий модуль для формата часов"
   54  cp "/c/JavaProjects/Modsen/src/Watch.java" timeModule/
   55  git add timeModule/Watch.java
   56  git commit -m "Добавлен класс часов"
   # Отправка на GitHub
   57  git push -u origin homework1
   58  git checkout main
   59  git checkout -b homework2
   60  mkdir library
   # Добавление классов библиотеки
   61  cp "/c/JavaProjects/Modsen/src/Book.java" library/
   62  git add library/Book.java
   63  git commit -m "Добавлен класс книга"
   64  cp "/c/JavaProjects/Modsen/src/Reader.java" library/
   65  git add library/Reader.java
   66  git commit -m "Добавлен класс читатель"
   67  cp "/c/JavaProjects/Modsen/src/Library.java" library/
   68  git add library/Library.java
   69  git commit -m "Добавлен класс библиотека"
   70  git push -u origin homework2
   71  git checkout main
   72  mkdir threads
   73  кmdir threads
   74  rmdir threads
   75  git checkout -b homework3
   76  mkdir threads
   77  ls
   # Добавление файлов по многопоточности
   78  git add .
   79  git commit -m "Добавлено задание по многопоточности"
   80  git push -u origin homework3
   81  git checkout main
   82  git checkout homework4
   83  git checkout -b homework4
   84  mkdir sql
   # Добавление SQL файлов
   85  cp "/c/Users/Honor/Downloads/Telegram Desktop/CREATE TABLES.txt" sql/
   86  git add sql/
   87  git commit -m "Добавлен код для создания таблиц и зависимостей"
   88  cp "/c/Users/Honor/Downloads/Telegram Desktop/SELECT.txt" sql/
   89  git add sql/
   90  git commit -m "Добавлен код для создания запросов"
   91  git push -u origin homework4
   92  git checkout main
   93  git checout -b homework5
   94  git checkout -b homework5
   95  mkdir api
   # Добавление API
   96  cp "/c/Users/Honor/Downloads/Telegram Desktop/Hotel.yaml" api/
   97  git add api/
   98  git commit -m "Добавлен api для отеля"
   99  git push -u origin homework5
  100  git checkout main
  101  git checkout -b homework6
  102  mkdir postman
  # Добавление Postman коллекций
  103  cp "/c/Users/Honor/Downloads/Telegram Desktop/My API.postman_collection.json" postman/
  104  git add postman/
  105  git commit -m "Добавлен импортиованный файл из postman"
  106  cp "/c/Users/Honor/Downloads/Telegram Desktop/Список нарушений.docx" postman/
  107  git add postman/
  108  git commit -m "Добавлен список нарушений"
  109  git push -u origin homework6
  110  history
