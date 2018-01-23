# ProyectoSD
__Requerimientos__

Java 8 o 9, Mongodb, Redis, Python 3, Maven

---

__Dataset no está incluido en el repositorio__

Dataset descargado de: https://archive.ics.uci.edu/ml/datasets/News+Aggregator

Descomprimir, se va a utilizar el archivo "newsCorpora.csv"

---

__Procesamiento del dataset__

1. Clonar este repositorio
2. Dentro de la carpeta Dataset, colocar el archivo "newsCorpora.csv"
3. En esta carpeta se tendrá un archivo .py, ejecutar este archivo con python(python arreglarCVS.py), la versión de python utilizada es la 3
4. En esta carpeta se tendrá un nuevo archivo llamado "newsCorpora_edit3.csv"
5. Borrar el archivo "newsCorpora.csv" y renombrar el archivo "newsCorpora_edit3.csv" a "newsCorpora.csv"
6. Abrir el archivo "newsCorpora.csv", agregar una fila al comienzo del archivo
7. Por cada columna se agregará los siguientes campos respectivamente

  | idnews        | title           | url  | publisher        | category           | story  |hostname        | timestamp           | views  |
  | ------------- |:-------------:| -----:| ------------- |:-------------:| -----:|------------- |:-------------:| -----:|
  
8. Guardar los cambios

---

__Llenar la base__

1. En línea de comandos ubicarse donde está el archivo cvs procesado "newsCorpora.csv"
2. Ejecutar el siguiente comando: mongoimport -d newsdb -c news --type csv --file newsCorpora.csv --headerline

---

__Correr los proyectos__

1. Instalar las dependencias correspondientes usando mvn install
2. Hacer por cada carpeta mvn clean package
3. Con el paquete generado hacer java -jar targer/%Nombre del paquete%

---

Servidor MicroServicio
159.89.36.53:2222

Servidor ApiGateway
159.89.40.125:8080

Rutas 
/news/day/%timestamp - epoch%
159.89.40.125:8080/news/day/1396051200000
