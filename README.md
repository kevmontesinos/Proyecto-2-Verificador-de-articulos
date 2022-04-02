# Proyecto 2 Verificador de articulos
## Requerimiento funcionales
### 1. Leer documento: El usuario podrá seleccionar un archivo txt mediante un JFileChooser, por ejemplo un artículo de programación, el programa deberá ser capaz de leer todas las palabras contenidas en el archivo e insertarlas en la estructura de datos. Cabe destacar que las lecturas de archivos son acumulativas, es decir, que al leer un segundo artículo los contadores de repetición no serán reiniciados. Recuerden eliminar los signos de puntuación del texto.
### 2. Contar repeticiones: El usuario debe poder conocer cuántas veces se repite una palabra del texto. Recordando que al guardar en la Estructura de Datos, se deberán tener en cuenta las repeticiones. No debe haber redundancia de información.
#### Ejemplo de output:
#### Palabra A del texto: frecuencia con la cual aparece en el cuerpo del texto.
#### Palabra B del texto: frecuencia con la cual aparece en el cuerpo del texto.
#### …
#### Palabra N del texto: frecuencia con la cual aparece en el cuerpo del texto.

### 3. Buscar palabra: El usuario debe poder consultar la existencia de una palabra en un determinado texto, con este fin se realizará una búsqueda en la Hash Table con una complejidad de O(1) o lo más cercana posible. Al realizar esta búsqueda se le notificará al usuario si la palabra se encuentra en el texto, y en caso de existir la cantidad de veces que se repite. 
#### Ejemplo de output si encuentra la palabra:Palabra buscada: frecuencia con la cual aparece en el cuerpo del texto.
### 4. Verificar originalidad del artículo: La violación de la propiedad intelectual es un gran problema en la actualidad, por lo tanto los artículos son sometidos a inspecciones. Para realizar una inspección se realiza el siguiente procedimiento:
### a. El usuario debe poder seleccionar el artículo que desee inspeccionar mediante un JFileChooser.
### b. Para inspeccionar un artículo se utiliza el algoritmo de Rabin-Karp , el cual es capaz de detectar si un fragmento determinado se encuentra dentro de todo el texto. Para ello el usuario introduce el fragmento de texto que desea verificar y el programa le indicará en qué parte del texto este se encuentra. A continuación un ejemplo:
#### Texto seleccionado:
#### IDE (Integrated Development Environment) is a place where programmers can create their own applications by writing the code. Normally the IDEs come with debuggers and compilers, which makes the work of programmers much easier.
#### Fragmento: is a place where programmers can create their own applications
#### Output:
#### El fragmento fue encontrado en la posición 41. Además, el fragmento debe ser resaltado de alguna forma en el texto, por ejemplo con algún signo delimitador.
### 5. Mostrar palabras más usadas: Finalmente, se requiere ver todas las palabras introducidas en la Hash Table ordenadas descendentemente por el número de repeticiones. Para la implementación de esta función NO se puede recorrer la Tabla de Dispersión, ya que sería extremadamente ineficiente. Para dar solución a este apartado será necesario implementar una lista simplemente enlazada utilizando los MISMOS nodos que la Hash Table para evitar la redundancia de información.
