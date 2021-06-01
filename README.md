# Probando la API de Machine Leaning de Firebase

<img width="302" alt="Captura de pantalla 2021-05-31 a la(s) 21 49 53" src="https://user-images.githubusercontent.com/28780954/120401414-46d51a80-c316-11eb-811f-8b4b75225f55.png">


### Temario

-  Qué es ?
-  Porqué usar MLKit de google ?
-  Funciona sin conexión ?
-  Cuales son las APIs disponibles ?
-  Cómo usar esta Librería ?



## Qué es ?

ML Kit es un SDK desarrollado por Google de aprendizaje automático disponible para las plataformas móviles de Android y iOS.

## Por qué elegirías usar MLKit ? 

<img width="1277" alt="Captura de pantalla 2021-05-31 a la(s) 21 45 18" src="https://user-images.githubusercontent.com/28780954/120401658-ca8f0700-c316-11eb-8d5a-b5fb3814f6ff.png">


***Reemplazaría todos estos procesos***

<img width="544" alt="Captura de pantalla 2021-06-01 a la(s) 20 20 35" src="https://user-images.githubusercontent.com/28780954/120401752-ff02c300-c316-11eb-9c58-d8c842bbfc81.png">



***Por solo implementar la API***

<img width="1082" alt="Captura de pantalla 2021-05-31 a la(s) 21 57 46" src="https://user-images.githubusercontent.com/28780954/120401830-29ed1700-c317-11eb-8409-f4cc0b33272c.png">


##Funciona sin conexión ?

Todas las API de ML Kit se ejecutan en el dispositivo, lo que permite casos de uso en tiempo real en los que desea procesar una transmisión de cámara en vivo, por ejemplo. Esto también significa que la funcionalidad está disponible sin conexión.


##Cuales son las APIs disponibles ?

Explore las API listas para usar: reconocimiento de texto , detección de rostros , escaneo de códigos de barras , etiquetado de imágenes , detección y seguimiento de objetos , detección de poses , segmentación de selfies , respuesta inteligente , traducción de texto e identificación de idioma .



##Cómo usar esta Librería ?

-  Paso 1: Crea un proyecto de Firebase
-  Paso 2: Registra tu app con Firebase
-  Paso 3: Agrega un archivo de configuración de Firebase
-  Paso 4: Agrega Firebase ML a nuestra app

<img width="403" alt="Captura de pantalla 2021-05-31 a la(s) 21 36 28" src="https://user-images.githubusercontent.com/28780954/120402053-a253d800-c317-11eb-9be3-ffce32d528dd.png">

<img width="347" alt="Captura de pantalla 2021-06-01 a la(s) 20 27 52" src="https://user-images.githubusercontent.com/28780954/120402161-e21abf80-c317-11eb-9a7c-c70f2f4faa44.png">

<img width="431" alt="Captura de pantalla 2021-06-01 a la(s) 20 28 42" src="https://user-images.githubusercontent.com/28780954/120402219-05456f00-c318-11eb-9385-33a26a468105.png">


## Agrega Firebase ML a nuestra app

````
    //build.gradle (project-level)        
    //Add rules to include the Google Services Gradle plugin:
   
    classpath 'com.google.gms:google-services:4.3.8
    
    

    
    
    //app/build.gradle
    //Apply the Google Services Gradle plugin:
        plugins {
            id 'com.android.application'
            id 'kotlin-android'
            id 'com.google.gms.google-services'
        }

    //Add the library dependency:
    implementation 'com.google.android.gms:play-services-mlkit-text-recognition:16.2.0'

````
    
## Reconocimiento de Textos

````
val recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)

recognizer.process(image)
   .addOnSuccessListener { visionText ->
       // Task completed successfully
      
   }
   .addOnFailureListener { e ->
       // Task failed with an exception
       
   }
   
````

