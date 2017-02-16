# dreamkas
Открываем консоль и переходим в каталог с проектом<br>
Вначале выполняем:<br>
mvn site<br>
Затем для запуска тестов и создания отчетов:<br>
mvn surefire-report:report<br>
<br>
Отчет сохраняется в dkweb\target\site , файл с отчетом surefire-report.html
<br>
Исходники находятся в каталоге dkweb/src/test/java. В ресурсах размещен драйвер браузера
