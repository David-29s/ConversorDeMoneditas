# Conversor de Monedas en Java

## Descripción

Este proyecto es un conversor de monedas desarrollado en Java que utiliza la API pública de [ExchangeRate-API](https://www.exchangerate-api.com) para obtener las tasas de cambio actualizadas en tiempo real. 

El programa permite al usuario seleccionar monedas base y destino, ingresar una cantidad y obtener el valor convertido, todo mediante una interfaz de texto en consola con un menú interactivo.

---

## Características

- Consulta las tasas de cambio más recientes desde la API.
- Soporta múltiples monedas como USD, EUR, MXN, ARS, BRL, COP y más.
- Menú interactivo para seleccionar monedas y realizar conversiones múltiples.
- Validaciones de entrada y manejo de errores en la comunicación con la API.
- Código modular dividido en clases para facilitar mantenimiento y ampliación.

---

## Requisitos

- Java 11 o superior (para usar `HttpClient`).
- Dependencia externa: [Gson](https://github.com/google/gson) para manejar JSON.
- Conexión a internet para consultar la API.
- Clave de API gratuita de [ExchangeRate-API](https://www.exchangerate-api.com).

---

## Instalación y uso

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu_usuario/conversor-de-monedas.git
    ```

2. Agrega la librería Gson a tu proyecto (por ejemplo, usando Maven o descargando el JAR).

3. Reemplaza `"TU_API_KEY"` en el código con tu clave de API válida.

4. Compila y ejecuta el programa:
    ```bash
    javac ConversorDeMonedas.java
    java ConversorDeMonedas
    ```

5. Sigue las instrucciones en pantalla para usar el menú y convertir monedas.

---

## Estructura del proyecto

- `ConversorDeMonedas.java` — Clase principal con el método `main`.
- `Menu.java` — Controla la interacción con el usuario y muestra el menú.
- `ApiClient.java` — Maneja la conexión y consultas a la API.
- `EntradaUsuario.java` — Lectura y validación de entradas del usuario.
- `Conversor.java` — Realiza los cálculos de conversión.
- Librería Gson — Para procesar datos JSON.

---

## Ejemplo de uso

Conversor de monedas

📊 Bienvenido/a al Conversor de Moneda 📊

1.USD a EUR

2.EUR a USD

3.USD a MXN

4.MXN a USD

5.Ingresar monedas manualmente

6.Salir

Seleccione una opción: 5
Ingrese la moneda base (USD, EUR, MXN): USD
Ingrese la moneda destino: ARS
Ingrese la cantidad a convertir: 100
✅ 100.00 USD equivalen a 9500.00 ARS

## Autor

David Sanchez
