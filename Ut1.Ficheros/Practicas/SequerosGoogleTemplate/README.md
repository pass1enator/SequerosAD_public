# Acceso a datos.
## Trabajando con ficheros.

# Introducción.

En esta práctica se trabaja con flujos de datos y escritura/lectura de ficheros usando las diferentes clases de java.io 

La práctica consiste en crear un pequeño Google, se abren un conjunto de ficheros de tipo txt que contienen texto, se abren y procesa palabra por palabra,
almacenando en una estructura este análisis, por ejemplo: posición dentro del fichero, contexto (palabras anteriores y posteriores) y fichero en el que se encuentra.

Una vez creado el índice es posible realizar búsquedas de palabras, mostrándose una lista en la que se indica el fichero, la posición y el contexto.

En la carpeta ficheros, se tiene una serie de archivos de tipo txt para probar.

El programa ha de poder:

- Leer un conjunto de ficheros y crear el índice.
- Realizar búsquedas en el índice.
- Guardar el índice en formato texto sin usar librerías de serialización.
- Cargar el índice a partir de los ficheros creados en Guardar.

Las palabras se han de preparar para ser procesadas, por ejemplo, no tienen sentido indexar las palabras "y", "la"....No aportan información y son muy comunes.
Se facilita la clase Index con los siguientes métodos vacios:
``` Java
public class Index {
   

    public Index() {
       
    }

    public void loadIndex(File file) {
       
    }

    public void saveIndex(File file) throws IOException {
   

    }

    public void addFiletoIndex(String name) throws FileNotFoundException {
      
    }

    public void addFilestoIndex(String names[]) throws FileNotFoundException {
       
    }

    public void addFiletoIndex(File file) throws FileNotFoundException {

        
    }

    public void addFilestoIndex(List<File> files) throws FileNotFoundException {

        
    }

    private void processWord(String word, String line, File f, double position) {
       
    }

    public ArrayList<Reference> findWord(String word) {
       
    }
    public void clear(){
        
    }

}
```

Se trabaja con un item modelado en la clase Reference:

``` Java

public class Reference {


    private String word;
    private File file;
    private double position;
    private String resume;
    public Reference(String word,File file, double position, String resume) {
        this.file = file;
        this.position = position;
        this.resume = resume;
        this.word = word;
    }
    public File getFile() {
        return file;
    }
    public String getFilename() {
        if(this.file!=null)
            return this.file.getName();
        else
            return "";
    }
    public void setFile(File file) {
        this.file = file;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getPosition() {
        return position;
    }

    public void setPosition(double position) {
        this.position = position;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

}
```
También se proporciona una interfaz gráfica sencilla.

** Se han de controlar las excepciones, mostrando mensajes de error en la interfaz gráfica **
# Recomendaciones.

    - Comenzar decidiendo la estructura de datos a usar para almacenar el índice.
    - Procesar un fichero, obteniendo cada una de las palabras del mismo.
    - Incluir la palabra en la estructura.
    - Hacerlo con un conjunto de ficheros.
    - Probar la búsqueda.
    - Guardar el índice en un fichero.
    - Cargar el índice a partir de un fichero.
