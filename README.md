Crear los POJO para representar Pelicula y Actor.

Crear el DAO de Pelicula, con las siguientes operaciones:
Insertar una película
Actualizar cualquier campo (menos ID) según su ID
Borrar una película según su ID
Obtener todas las películas con su número total de actores
Obtener todos los actores de una película dado su ID
Obtener las películas con más de 3 actores
Obtener las 3 películas con mayor presupuesto
Obtener la película más larga de un género dado por parámetro

Crear el DAO de Actor, con las siguientes operaciones:
Insertar un actor
Actualizar cualquier campo (menos ID) según su ID
Borrar un actor según su ID
Asignar un actor a una película, según sus ID, y con un personaje dado por parámetro
Eliminar un actor de una película, según sus ID
Obtener el número de actores de cada nacionalidad
Obtener la edad media de los actores
Obtener los actores que no han participado en ninguna película

En la clase Main, ejecutar todas las operaciones.
Para inserción, actualización y borrado, se recomienda usar un mismo objeto para las tres operaciones.
Para añadir un actor a una película y luego eliminarlo, se recomienda usar el mismo actor y la misma película en ambos casos.
El objetivo es que el Main pueda ejecutarse varias veces y que los resultados de las consultas no cambien.
