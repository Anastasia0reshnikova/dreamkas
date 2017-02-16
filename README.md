# dreamkas
Исходники находятся в каталоге dkweb/src/test/java. В ресурсах размещен драйвер браузера
<br>

Автотесты можно скачать через кнопку downloads или консольную команду git clone https://github.com/Anastasia0reshnikova/dreamkas.git
<br>
Открыть среду разработки IDE Idea и выполнить Open, указав pom.xml
<br>
Кликнуть на вкладку Maven Project
<br>
Кликнуть по кнопке Execute Maven Goal и ввести комманды указанные ниже
<br>
Вначале выполняем:<br>
mvn site<br>
Затем для запуска тестов и создания отчетов:<br>
mvn surefire-report:report<br>
<br>
Отчет сохраняется в dkweb\target\site , файл с отчетом surefire-report.html
<br>
<br>
Я думаю, что можно это сделать все через консоль операционной системы, но не разбиралась как.
