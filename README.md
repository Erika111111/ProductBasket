# ProductBasket

Название проекта: Продуктовая корзина (Product Basket)

Product Basket - это простое RESTful веб-приложение, использующее Spring Boot для управления продуктами.

▎Описание кода:
1. Модель Product:
   Класс Product представляет собой сущность, которая будет храниться в базе данных. Он содержит поля:
        • id: уникальный идентификатор продукта.
        • name: название продукта.
        • description: описание продукта.
        • kcal: калорийность продукта.

2. Репозиторий ProductRepository:
   • Интерфейс ProductRepository наследуется от JpaRepository, что позволяет использовать стандартные методы для работы с сущностями (например, save, findAll, deleteById).
   • Метод findByName позволяет искать продукты по имени.

3. Сервис ProductService:
   • Класс ProductService содержит бизнес-логику приложения и использует репозиторий для выполнения операций с продуктами.
   • Методы:
   • addProduct: добавляет новый продукт.
   • getAllProduct: возвращает список всех продуктов.
   • deleteProduct: удаляет продукт по идентификатору.
   • searchProducts: ищет продукты по имени.

4. Контроллер ProductController:
   • Класс ProductController обрабатывает HTTP-запросы и взаимодействует с сервисом для выполнения операций CRUD (Create, Read, Update, Delete).
   • Методы:
   • createProduct: обрабатывает POST-запрос для создания нового продукта.
   • getAllProduct: обрабатывает GET-запрос для получения всех продуктов.
   • searchProducts: обрабатывает GET-запрос для поиска продуктов по имени.
   • updateProduct: обрабатывает PUT-запрос для обновления существующего продукта.
   • deleteProduct: обрабатывает DELETE-запрос для удаления продукта.

Для проверки работы программы я использую HTTPie.

Проверка работы метода для создания нового продукта (POST):

<img width="1440" alt="1" src="https://github.com/user-attachments/assets/188ae3d2-b795-49f5-8797-678c6e37298b" />
<img width="1440" alt="2" src="https://github.com/user-attachments/assets/f0d50504-793c-4dd4-992a-f751d3cbbcd9" />
<img width="1440" alt="3" src="https://github.com/user-attachments/assets/2f55de09-a7df-4942-961c-ace91230f859" />


Для проверки работы метода изменения статуса задачи необходимо в строке URL выбрать PUT и указать http://localhost:8080/api/products/{id}, где {id} - это идентификатор продукта, который необходимо обновить.
В теле запроса указываем JSON объект с необходимыми обновлениями:
<img width="1440" alt="4" src="https://github.com/user-attachments/assets/0ca7e9b3-9796-4da8-b818-7e77812f2df9" />


Для проверки метода удаления продукта из списка (DELETE) необходимо в строке URL выбрать тип запроса «DELETE» и указать http://localhost:8080/api/products/{id}, где {id} - это идентификатор продукта, который необходимо удалить. 
<img width="1440" alt="6" src="https://github.com/user-attachments/assets/8e01570b-c724-442e-919d-905a102c6b2b" />


Для провекри метода поиска продукта по имени, необходимо в строке URL выбрать GET и указать http://localhost:8080/api/products/search?name=ваш_поисковой_запрос, замените ваш_поисковой_запрос на название продукта, который необходимо найти.
<img width="1440" alt="7" src="https://github.com/user-attachments/assets/ff20577d-4338-4443-ad5a-3c05e8873f98" />


