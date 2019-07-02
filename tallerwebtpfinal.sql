
CREATE DATABASE IF NOT EXISTS tallerwebtpfinal;
use tallerwebtpfinal;


INSERT INTO imagenfondo(nombreimgfondo)
VALUES("Entrada.jpg");


INSERT INTO pregunta(id, textoDeLaPregunta,imagenfondo_id)
VALUES(1,"Luego de terminar la secundaria, decidi ingresar a la Universidad. Aprobe el curso de ingreso en el primer intento.
Despues de unas pequeÃ±as vacaciones, ha llegado el primer dia de mi carrera universitaria.
Decidi elegir Desarrollo web, ya que siempre me ha gustado la informatica.
La primera materia es matematicas, en el aula 232. Segun el mapa de la pagina web, puedo llegar hasta alla desde el departamento de Humanidades o el de Ingenieria.
Â¿Por cual deberia ir?",1),
(2,"Â¡Primer dia de clases y ya estoy llegando tarde!
Bueno, este debe ser el aula. Me peino un poco y entro.<br><br> 
- Jugador: Buenos dias profesor.<br>
- Profesor: Buenas noches, en el fondo hay una silla desocupada.<br>
- Profesor: Bien...El segundo calculo para resolver este ejercicio es...<br>
No entiendo que esta explicando. <br>Â¿Deberia preguntarle a mi compaÃ±ero?",1),
(3,"Se lo ve muy concentrado, mejor no le hablo. <br>
-CompaÃ±ero: Disculpame, mi nombre es Pablo, Â¿entendiste lo que el profesor explicaba sobre el rectangulo? <br>
Lo miro y respondo.<br>
-Jugador: Hola, yo tampoco entendi. Por cierto, me llamo /nombre/.<br>
Terminamos los dos riendonos.",1),

(4,"Has perdido por Estres",1),
(5,"Has abandonado por Rendimiento",1),
(6,"Has desaprobado pero eres popular",1);



INSERT INTO respuesta(id, rendimiento, social, estres, dinero, opcion, pregunta_id, preguntaSiguiente_id)
VALUES(100,30,30,30,200,"Jugar",null,1),
(101,25,30,10,200,"Humanidades",1,2),
(1011,35,-10,20,200,"Ingenieria",1,null),
(102,-5,12,100,200,"No preguntarle",2,3),
(103,0,0,0,0,"Inicio",4,null),
(104,0,0,0,0,"Inicio",5,null),
(105,0,0,0,0,"Inicio",6,null);





INSERT INTO imagenpersonaje(nombre)
VALUES("Daiana%20(1).png"),
("Nicolas%20(1).png"),
("Pablo%20(1).png");

							
Insert into tablapreguntapersonaje(idpregunta, idimagenpersonaje)
value (1,1),
(2,1),
(3,1),
(3,2),
(4,1);


INSERT INTO imagenfondo_pregunta(imagenfondo_id,pregunta_id)
VALUES(1,1),
(1,2),
(1,3),
(1,4);


SELECT * FROM RESPUESTA;
SELECT * FROM PREGUNTA;
SELECT * FROM jugador;
SELECT * FROM Estadistica; 
select * from imagenfondo; 
select * from imagenpersonaje; 
select * from tablajugadorrespuesta;
select * from tablapreguntapersonaje;
select * from imagenfondo_pregunta;
