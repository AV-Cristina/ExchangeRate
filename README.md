# ExchangeRate
Android-приложение, загружающее курсы валют с сайта Центробанка РФ

1. ExchangeRateActivity 
   <br>Активность, загружающая из интернета и отображающая курсы валют.

   Загрузка выполняется в фоновом потоке с помощью метода doInBackground класса DownloadXmlTask, наследующего AsyncTask. Для этого:
   - Создается список элементов List<Currency> currencyList;
   - Создается парсер CurrencyXmlParser currencyXmlParser;
   - Методом xmlLoader.loadXmlFromNetwork() выполняется подключение, запрос xml-страницы и передача её парсеру;
   - Парсер CurrencyXmlParser currencyXmlParser зполняет список currencyList. 

   После того как список будет заполнен, он выводится методом onPostExecute в кастомизированый список с помощью адаптера CurrencyListAdapter currencyListAdapter.


2. Currency - класс, описывающий свойства объектов Currency (валюта), содержит следующие поля:
    <br>private String charCode;
    <br>private String name;
    <br>private String nominal;
    <br>private String value;
	
    Предоставляет геттеры и сеттеры для доступа к этим полям.
	
3. CurrencyXmlParser - парсер, заполняющий список элементов Currency данными из xml-файла.

4. CurrencyListAdapter - адаптер для отображения кастомизированного списка.

5. XmlLoader загружает файл и передает его парсеру.
