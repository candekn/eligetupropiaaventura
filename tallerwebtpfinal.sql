/*Ejecutar en Mysql
 
 Antes, hay que modificar el tamaño del varchar(650) del texto de la ruta
 en el Mysql, si no no va a guardar los textos largos
 
// En la tabla ruta:

insert into ruta(opcion1, opcion2, texto)
values("Humanidades","Ingenieria","Luego de terminar la secundaria, decidí ingresar a la Universidad. Aprobé el curso de ingreso en el primer intento.
Después de unas pequeñas vacaciones, ha llegado el primer día de mi carrera universitaria.
Decidí elegir Desarrollo web, ya que siempre me ha gustado la informática.
La primera materia es matemáticas, en el aula 232. Según el mapa de la página web, puedo llegar hasta allí desde el departamento de Humanidades o el de Ingeniería.
¿Por cuál debería ir?");



insert into ruta(opcion1, opcion2, texto)
values ("No preguntar","Preguntarle","¡Primer día de clases y ya estoy llegando tarde!

Bueno, este debe ser el aula. Me peino un poco y entro.

- Jugador: Buenos días profesor.

- Profesor: Buenas noches, en el fondo hay una silla desocupada.

- Profesor: “...El segundo cálculo para resolver este ejercicio es...”

No entiendo qué está explicando. ¿Debería preguntarle a mi compañero?");


// En la tabla respuesta:

use tallerwebtpfinal;
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (10,10,10,10,"Jugar",1);
Insert into respuesta(rendimiento,social,estres,dinero,respuesta,ruta_id) values (4,-3,-2,1,"Humanidades",2);
 */
