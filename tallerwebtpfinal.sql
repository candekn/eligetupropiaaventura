
CREATE DATABASE IF NOT EXISTS tallerwebtpfinal;
use tallerwebtpfinal;
INSERT INTO pregunta(id, textoDeLaPregunta)
VALUES(1,"Luego de terminar la secundaria, decidí ingresar a la Universidad. Aprobé el curso de ingreso en el primer intento.
Después de unas pequeñas vacaciones, ha llegado el primer día de mi carrera universitaria.
Decidí elegir Desarrollo web, ya que siempre me ha gustado la informática.
La primera materia es matemáticas, en el aula 232. Según el mapa de la página web, puedo llegar hasta allí desde el departamento de Humanidades o el de Ingeniería.
¿Por cuál debería ir?"),
(2,"¡Primer día de clases y ya estoy llegando tarde!
Bueno, este debe ser el aula. Me peino un poco y entro. 
- Jugador: Buenos días profesor.
- Profesor: Buenas noches, en el fondo hay una silla desocupada.
- Profesor: “...El segundo cálculo para resolver este ejercicio es...”
No entiendo qué está explicando. ¿Debería preguntarle a mi compañero?"),
(3,"Se lo ve muy concentrado, mejor no le hablo. 
-Compañero: Disculpame, mi nombre es Pablo, ¿entendiste lo que el profesor explicaba sobre el rectángulo?” 
Lo miro y respondo.
-Jugador: Hola, yo tampoco entendí. Por cierto, me llamo /nombre/.
Terminamos los dos riéndonos.");

INSERT INTO respuesta(id, opcion, pregunta_id, preguntaSiguiente_id)
VALUES(100,"Jugar",null,1),
(101,"Humanidades",1,2),
(1011,"Ingeniería",1,null),
(102,"No preguntarle",2,3);

SELECT * FROM RESPUESTA;
SELECT * FROM PREGUNTA;
