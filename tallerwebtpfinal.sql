
CREATE DATABASE IF NOT EXISTS tallerwebtpfinal;

use tallerwebtpfinal;
INSERT INTO pregunta(id, textoDeLaPregunta, imagen)
VALUES(1,"Luego de terminar la secundaria, decidi ingresar a la Universidad. Aprobe el curso de ingreso en el primer intento.
Despues de unas pequeñas vacaciones, ha llegado el primer dia de mi carrera universitaria.
Decidi elegir Desarrollo web, ya que siempre me ha gustado la informatica.
La primera materia es matematicas, en el aula 232. Segun el mapa de la pagina web, puedo llegar hasta alla desde el departamento de Humanidades o el de Ingenieria.
¿Por cual deberia ir?", "Entrada.jpg"),
(2,"¡Primer dia de clases y ya estoy llegando tarde!
Bueno, este debe ser el aula. Me peino un poco y entro.<br><br> 
- Jugador: Buenos dias profesor.<br>
- Profesor: Buenas noches, en el fondo hay una silla desocupada.<br>
- Profesor: Bien...El segundo calculo para resolver este ejercicio es...<br>
No entiendo que esta explicando. <br>¿Deberia preguntarle a mi compañero?","imagenProbando.jpg"),
(3,"Se lo ve muy concentrado, mejor no le hablo. <br>
-Compañero: Disculpame, mi nombre es Pablo, ¿entendiste lo que el profesor explicaba sobre el rectangulo? <br>
Lo miro y respondo.<br>
-Jugador: Hola, yo tampoco entendi. Por cierto, me llamo /nombre/.<br>
Terminamos los dos riendonos.","Entrada.jpg"),

(4,"Has perdido por Estres","Entrada.jpg"),
(5,"Has abandonado por Rendimiento","Entrada.jpg"),
(6,"Has desaprobado pero eres popular","Entrada.jpg");



INSERT INTO respuesta(id, rendimiento, social, estres, dinero, opcion, pregunta_id, preguntaSiguiente_id)
VALUES(100,30,30,30,200,"Jugar",null,1),
(101,25,30,10,200,"Humanidades",1,2),
(1011,35,-10,20,200,"Ingenieria",1,null),
(102,-5,12,100,200,"No preguntarle",2,3),
(103,0,0,0,0,"Inicio",4,null),
(104,0,0,0,0,"Inicio",5,null),
(105,0,0,0,0,"Inicio",6,null);

SELECT * FROM RESPUESTA;
SELECT * FROM PREGUNTA;
