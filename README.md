# README #

Proyecto de prueba

### HERRAMIENTAS USADAS ###

Este proyecto esta creado sobre el modelo de automatización Page Object, usando librerías
de Serenity, además se usa la metodología BDD apoyada con CUCUMBER.

Como gestor de dependencias se usó gradle, para dar formato al código se usó el style java de google,
con el fin de optimizar el código en los modelos, se uso el plugin Lombok.

### Pruebas realizadas ###

Las pruebas se hacen partiendo de test exploratorios sobre la pagina https://www.esika.com/pe

La prueba está delimitada por la validación de la gestión de compra de un producto y adición correcta de una dirección de envio

Se usa la metodología BDD, donde se plantean los escenarios en lenguaje de negocio y orientado al comportamiento,
haciendo una integración de la capa de negocio a la técnica, se plantean escenarios parametrizables para variar facilmente la data de prueba

Dado que se uso BDD para este proyecto, la documentación de los casos de prueba es en si mismo el reporte generado por la ejecución
(Living documentation)

### Ejecución de test ###

La ejecución está configurada sobre el navegador google Chrome para la versión 89. la ruta del driver y capabilities están
configurados desde el archivo serenity.properties dentro del proyecto.
La ruta por defecto para el WebDriver está configurada para la raíz del proyecto
Tambien pueden ejecutarse los test en un selenium grid dockerizado dentro del proyecto, las capabilities
tambien estan en el serenity.properties

Para subir la grilla docker ejecute el comando docker-compose up -d en la raiz del proyecto

Para ejecutar la prueba, diríjase al runner "ReservationRunner", por efectos de generación del reporte
se recomienda ejecutar la prueba usando gradle, puede usarse el comando "gradle clean test"

### Reportes ###

Los reportes generados por la ejecución quedarán en la carpeta Target, para observar el reporta
abra el archivo index.html desde cualquier navegador