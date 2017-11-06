package ru.smarty.resume

/**
 * Версия для не-программистов: http://smarty.ru/cv (Генерируется по описанию ниже)
 */
val cv: CV = makeCV {
    name = "Юрий Малинов"

    contacts {
        email = "yurik.m@gmail.com"
        skype = "yurik.m"
        phone = "+7-917-378-4605"
        github = "https://github.com/YuriMalinov/"
        linkedin = "https://www.linkedin.com/in/yuri-malinov/"
    }

    short {
        "Совсем коротко" {
            +"13 лет работаю в разработке, прошёл путь от разработчика до тимлида/менеджера проекта."
            +"Разработал и запустил более 10 проектов (не считая массы небольших проектов)."
            +"Умею работать с нагрузкой и сложной логикой."
        }

        "Подробнее, умею" {
            +"Разрабатывать интересные штуки на Java платформе, Spring, Spring Boot, JPA, Jdbc."
            +"Много языков - Java, Kotlin, Scala, Python, PHP, JavaScript/TypeScript, и люблю изучать новые."
            +"Java Concurrency."
            +"Java Collections и алгоритмы."
            +"Работать с данными - большой опыт SQL и работа с NoSQL решениями."
            +"Руководить разработкой - локальные/распределённые команды, Agile."
            +"Разбираться в чужом коде и делать его лучше, так, чтобы ничего не сломать."
            +"В т.ч. разбираться как там работает Spring или Hibernate под капотом."
            +"Пишу тесты (но без фанатизма, поменьше моков, побольше дела)."
        }

        "Есть опыт" {
            +"Работы с большими проектами, как по сложности, так и по нагрузке."
            +"Организации мониторинга с InfluxDB и Grafana, и немного Zabbix."
            +"Развёртывания и настройки сервисов как руками, так и под Docker (и да, уверенная работа с консолью Linux)."
            +"Организации взаимодействия между сервисами."
            +"Работы с GIT, тасктрекерами, wiki и т.п."
        }

        "Хочу" {
            +"Решать нетривиальные задачи в сложных проектах."
            +"Работать в команде профессионалов."
            +"Изучить и применить новые для себя знания и практики."
        }
    }

    education = listOf(
            Education(
                    year = 2007,
                    name = "Московский институт электронной техники, Москва",
                    speciality = "Магистр, МПиТК, Программное обеспечение вычислительной техники и автоматизированных систем"),
            Education(
                    year = 2006,
                    name = "Институт международного бизнес образования, Москва",
                    speciality = "Бакалавр, Менеджмент"))


    // @formatter:off

    val skills = object {
        val Java        by +group(Lang(years = 6))
        val Kotlin      by +Lang(years = 3, notes = "Как Java, только +100 к понятности и приятности")
        val Spring      by +Tech(Java)
        val SpringBoot  by +Tech(Java)
        val Hibernate   by +Tech(Java)
        val Guice       by +Tech(Java)
        val GWT         by +Tech(Java)
        val Rhino       by +Tech()

        val Scala       by +group(Lang(years = 1, notes = "1 год - в общей сложности, эпизодические контакты длиною в 6 лет"))
        val Play2       by +Tech(Scala)
        val Squeryl     by +Tech(Scala)

        val JavaScript  by +group(Lang(years = 13))
        val AngularJS   by +Tech(JavaScript)
        val VueJS       by +Tech(JavaScript)
        val TypeScript  by +Lang(years = 3)

        val Scripting   by +group(Lang())
        val Python      by +Lang(years = 2, notes = "Также, периодические контакты на протяжении 8 лет")
        val Django      by +Tech(Python)
        val PHP         by +Tech()

        val SQL         by +group(Lang(years = 13, notes = "Много самых разных, от MySQL до Oracle и PostgreSQL"))
        val PostgreSQL  by +Tech(SQL)
        val MySQL       by +Tech(SQL)
        val Oracle      by +Tech(SQL)

        val NoSQL       by +group(Lang(years = 3, notes = "Некоторые из них"))
        val RocksDB     by +Tech(NoSQL)
        val MongoDB     by +Tech(NoSQL)
        val ClickHouse  by +Tech(NoSQL)
        val InfluxDB    by +Tech(NoSQL)
        val Grafana     by +Tech(NoSQL)

        val Misc        by +group(Tech())
        val RabbitMQ    by +Tech()
        val GIT         by +Tech()
        val Docker      by +Tech()

        val SoftSkills  by +group(Tech(name = "Soft Skills"))
        val ProjectManagement by +Skill(name = "Управление проектами")
        val Agile       by +Skill()

        val English     by +Lang(years = 20, notes = "Хорошее знание английского, могу свободно говорить на технические темы")
    }


    val roles = object {
        val Architect       by +Role()
        val LeadDeveloper   by +Role()
        val Developer       by +Role()
        val ProjectManager  by +Role()
        val ProductManager  by +Role()
        val PreSale         by +Role()
        val Initiator       by +Role()
    }
    // @formatter:on


    val topProjects = object {
        val ServiceTourBook by +Project(
                description = """
                    Технический сателит TopHotels.ru/генератор трафика:
                    кэш поисков туров/диспетчеризация очередей поиска туров для отображения ценовой информации на TopHotels.ru
                    (900 запросов/сек на показы различных блоков, без учёта статики)""".trimIndent(),
                skills = listOf(skills.Spring, skills.SpringBoot, skills.Hibernate, skills.RocksDB, skills.RabbitMQ, skills.GIT, skills.ClickHouse, skills.InfluxDB, skills.Grafana),
                roles = listOf(roles.Initiator, roles.ProjectManager, roles.Architect, roles.LeadDeveloper))


        val OracleTourBook by +Project(
                description = """
                    Технический сателит TopHotels.ru. Создание профиля интересов пользователя (поиски, просмотренные отели, цены, которые видел, нажимал и т.д.).
                    """.trimIndent(),
                skills = listOf(skills.Spring, skills.SpringBoot, skills.MongoDB, skills.Docker, skills.GIT, skills.InfluxDB, skills.Grafana),
                roles = listOf(roles.Initiator, roles.ProjectManager, roles.Architect))


        val DistribTourBook by +Project(
                description = """
                    Система управления заявками на туры:
                    - сбор со всех проектов, обработка, распределение по клиентам
                    - аукцион, биллинг, отчётность
                    - интерфейс для клиентов
                    """.trimIndent(),
                skills = listOf(skills.PHP, skills.PostgreSQL, skills.RabbitMQ, skills.GIT),
                roles = listOf(roles.ProjectManager, roles.Architect))


        val TourBook by +Project(
                description = """
                    Технический сателит TopHotels.ru. Создание профиля интересов пользователя (поиски, просмотренные отели, цены, которые видел, нажимал и т.д.).
                    """.trimIndent(),
                skills = listOf(skills.PHP, skills.PostgreSQL, skills.AngularJS, skills.GIT),
                roles = listOf(roles.ProjectManager, roles.ProductManager, roles.Architect))


        val TourManagerPro by +Project(
                description = """
                    Система управления деятельностью туроператора:
                    - импорт/редактирование данных,
                    - составление пакетных туров,
                    - поиск, бронирование,
                    - документооборот, отчётность

                    Проект прошёл непростую судьбу от Scala + Guice -> Java + Spring MVC, от GWT в AngularJS.
                    """.trimIndent(),
                skills = listOf(skills.PHP, skills.PostgreSQL, skills.Spring, skills.GWT, skills.Guice, skills.AngularJS, skills.GIT),
                roles = listOf(roles.ProjectManager, roles.ProductManager, roles.Architect, roles.LeadDeveloper, roles.PreSale))


        val TourMarketInfo by +Project(
                description = "Анализатор базы в 2 млрд. предложений (с приличной скоростью обновления) на предмет различных маркетинговых исследований.",
                skills = listOf(skills.PHP, skills.JavaScript, skills.Oracle),
                roles = listOf(roles.Developer, roles.LeadDeveloper))

        val HotelBook by +Project(
                description = "Агрегатор GDS систем поиска и бронирования отелей. Заказной проект.",
                skills = listOf(skills.PHP, skills.JavaScript, skills.MySQL),
                roles = listOf(roles.Developer, roles.LeadDeveloper))

        val Netlog by +Project(
                description = "Счётчик посещаемости (хиты, хосты, визиты, по страничкам и т.д.)",
                skills = listOf(skills.PHP, skills.JavaScript, skills.MySQL),
                roles = listOf(roles.Developer))

        val AdvBroker by +Project(
                description = "Баннеро-крутилка",
                skills = listOf(skills.PHP, skills.JavaScript, skills.MySQL),
                roles = listOf(roles.Developer))
    }


    val notablePetProjects = object {
        val Bugster by +Project(
                description = "Агрегатор ошибок с различных проектов компании + интерфейс просмотра. " +
                        "Родился как ответ на необходимость поставить процесс улучшения качества проектов." +
                        "Позже портирован на SpringBoot для простоты поддержки.",
                skills = listOf(skills.Play2, skills.Squeryl, skills.SpringBoot),
                roles = listOf(roles.Initiator, roles.Developer))

        val LightInfo by +Project(
                description = "Мини-вики для ведения документации",
                skills = listOf(skills.Play2, skills.Squeryl, skills.JavaScript, skills.Rhino),
                roles = listOf(roles.Initiator, roles.Developer))

        val LightSupport by +Project(
                description = "Мини-трекер для ведения обращений клиентов по TourManagerPro",
                skills = listOf(skills.Django, skills.JavaScript),
                roles = listOf(roles.Initiator, roles.Developer))
    }



    experience {
        "Руководитель отдела разработки ПО" {
            company = "LightSoft Research"
            timeRange = "декабрь 2014" - "Сейчас"
            shortDescription = "Управление группой проектов"
            tasks = listOf(
                    "Работа с несколькими группами разработки (до 15-ти человек подчинённых в общей сложности)",
                    "Проектирование функционала и архитектуры проектов",
                    "Работа с дизайнерами и верстальщиками",
                    "Организация работы с офисными/удалёнными сотрудниками, Agile",
                    "Выстраивание процессов разработки, документирования и техподдержки",
                    "Проработка функциональных требований с нетехническими сотрудниками",
                    "Проработка различных технических и нетехнических процессов",
                    "Анализ и оценка трудоёмкости задач",
                    "Подбор и собеседование сотрудников",
                    "Обучение и наставничество",
                    "Оценка результативности",
                    "Разработка схемы мотивации и расчёт бонусов")

            projects = listOf(
                    topProjects.ServiceTourBook,
                    topProjects.OracleTourBook,
                    topProjects.DistribTourBook,
                    topProjects.TourBook,
                    topProjects.TourManagerPro)
        }

        "Руководитель проекта" {
            company = "LightSoft Research"
            timeRange = "май 2009" - "декабрь 2014"
            shortDescription = "Руководство проектом и группой разработчиков"
            tasks = listOf(
                    "Организация работы с офисными/удалёнными сотрудниками",
                    "Проектирование функционала и архитектуры проектов",
                    "Технический presale",
                    "Взаимодействие с клиентами, сбор требований",
                    "Выстраивание системы документирования и техподдержки",
                    "Подбор и собеседование сотрудников",
                    "Обучение и наставничество",
                    "Оценка результативности",
                    "Разработка схемы мотивации и расчёт бонусов")

            projects = listOf(
                    topProjects.TourManagerPro,
                    notablePetProjects.Bugster,
                    notablePetProjects.LightInfo)
        }

        "Старший программист" {
            company = "LightSoft Research"
            timeRange = "апрель 2006" - "апрель 2009"
            shortDescription = "Руководство группой разработчиков"
            tasks = listOf(
                    "1-4 подчинённых",
                    "подбор и собеседование сотрудников",
                    "обучение и наставничество",
                    "проектирование, архитектура",
                    "делегирование задач")

            projects = listOf(
                    topProjects.HotelBook,
                    topProjects.TourMarketInfo)
        }

        "Программист" {
            company = "LightSoft Research"
            timeRange = "июнь 2004" - "март 2006"
            shortDescription = "Разработка проектов в команде разработчиков."
            tasks = listOf(
                    "разработка проектов",
                    "разработка фреймворка",
                    "выбор технических решений")

            projects = listOf(
                    topProjects.Netlog,
                    topProjects.AdvBroker)
        }
    }
}